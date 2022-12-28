package com.example.composeastrosign.ui.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeastrosign.ui.screens.main.MainViewModel

@Composable
fun DetailsScreen(
    sign: String, day: String, icon: String,
) {
    val vm: MainViewModel = hiltViewModel()
    vm.getZodiacSignData(sign, day)

    if (vm.list.value.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

        }
    }
    if (vm.list.value.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(modifier = Modifier.align(Alignment.Center), text = vm.list.value.error)

        }
    }
    if(vm.list.value.data.description.isNotBlank()){
        DetailsScreenContent(vm.list.value.data,icon.toInt(),sign,day)

    }


}
