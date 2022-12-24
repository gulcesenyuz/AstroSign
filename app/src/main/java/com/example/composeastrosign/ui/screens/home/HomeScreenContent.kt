package com.example.composeastrosign.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeastrosign.ui.screens.components.GridSnackCardWithTitle
import com.example.composeastrosign.ui.screens.model.MenuItemModel

@Composable
fun HomeScreenContent(
    menuList: ArrayList<MenuItemModel>,
    tabPage: String,
    navController: NavHostController,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp)

    ) {
        itemsIndexed(menuList) { index, sign ->
            Row(Modifier.padding(8.dp)) {
                GridSnackCardWithTitle(sign,navController,tabPage)
            }
        }
    }
}