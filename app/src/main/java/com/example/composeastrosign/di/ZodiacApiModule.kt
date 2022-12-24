package com.example.composeastrosign.di

import com.example.composeastrosign.BuildConfig
import com.example.composeastrosign.data.api.ZodiacSignApi
import com.example.composeastrosign.data.repository.ZodiacSignRepository
import com.example.composeastrosign.data.util.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

private const val LOGGING_INTERCEPTOR = "logging_interceptor"
private const val HEADER_INTERCEPTOR = "header_interceptor"

@Module
@InstallIn(SingletonComponent::class)
object ZodiacApiModule {


    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    @Named(HEADER_INTERCEPTOR)
    fun provideHeaderInterceptor(): Interceptor = Interceptor {
        val newRequest = it.request().newBuilder()
            .addHeader("X-RapidAPI-Key", ApiConstants.API_KEY)
            .addHeader("X-RapidAPI-Host", ApiConstants.API_HOST)
            .build()

        it.proceed(newRequest)
    }

    @Singleton
    @Provides
    @Named(LOGGING_INTERCEPTOR)
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        )

    @Provides
    @Singleton
    fun provideHttpClient(
        @Named(LOGGING_INTERCEPTOR) loggingInterceptor: Interceptor,
        @Named(HEADER_INTERCEPTOR) headerInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ZodiacSignApi {
        return retrofit.create(ZodiacSignApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(api: ZodiacSignApi): ZodiacSignRepository {
        return ZodiacSignRepository(zodiacSignApi = api)
    }

}