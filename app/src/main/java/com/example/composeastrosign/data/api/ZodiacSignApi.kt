package com.example.composeastrosign.data.api

import com.example.composeastrosign.data.model.ZodiacSignModel
import retrofit2.http.POST
import retrofit2.http.Query

interface ZodiacSignApi {

    @POST(".")
    suspend fun getZodiacSign(
        @Query("sign") sign: String,
        @Query("day") day: String
    ): ZodiacSignModel
}
