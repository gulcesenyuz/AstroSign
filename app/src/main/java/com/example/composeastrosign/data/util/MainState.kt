package com.example.composeastrosign.data.util

import com.example.composeastrosign.data.model.ZodiacSignModel

data class MainState(
    val isLoading: Boolean = false,
    val data: ZodiacSignModel = ZodiacSignModel("","","","","","","","") ,
    val error: String = ""

)
