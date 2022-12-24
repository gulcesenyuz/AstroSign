package com.example.composeastrosign.ui.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeastrosign.data.repository.ZodiacSignRepository
import com.example.composeastrosign.data.util.MainState
import com.example.composeastrosign.data.util.Resource
import com.example.composeastrosign.ui.screens.model.MenuItemModel
import com.example.composeastrosign.ui.screens.signIconList
import com.example.composeastrosign.ui.screens.signList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val zodiacSignRepository: ZodiacSignRepository
) : ViewModel() {

    val list: MutableState<MainState> = mutableStateOf(MainState())
    var menuList: ArrayList<MenuItemModel> = ArrayList<MenuItemModel>()

    fun getZodiacSignData(sign: String, day: String) = viewModelScope.launch {
        val result = zodiacSignRepository.getZodiacSign(sign = sign, day = day)

        when (result) {
            is Resource.Loading -> {
                list.value = MainState(isLoading = true)
            }
            is Resource.Error -> {
                list.value = MainState(error = "Something Went Wrong")
            }
            is Resource.Success -> {
                list.value= result.data?.let { MainState(data = it) }!!
            }
        }
    }

    fun createMenuItemModel(){
        for (i in signList.indices) {
            menuList.add(MenuItemModel(i,signList[i], signIconList[i]))
        }

    }
}