package com.example.composeastrosign.data.repository

import com.example.composeastrosign.data.api.ZodiacSignApi
import com.example.composeastrosign.data.model.ZodiacSignModel
import com.example.composeastrosign.data.util.Resource
import javax.inject.Inject

class ZodiacSignRepository @Inject constructor(
    private val zodiacSignApi: ZodiacSignApi
) {

    suspend fun getZodiacSign(sign: String, day: String): Resource<ZodiacSignModel> {

        return try {
            val result = zodiacSignApi.getZodiacSign(sign = sign, day = day)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

}