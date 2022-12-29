package com.example.composeastrosign.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.composeastrosign.graph.TabHome
import com.example.composeastrosign.graph.TabPage
import com.example.composeastrosign.ui.screens.main.MainViewModel


@Composable
fun HomeScreen(
    navController: NavHostController
) {
    var tabPage by remember {
        mutableStateOf(TabPage.Today)
    }
    val vm: MainViewModel = hiltViewModel()
    vm.createMenuItemModel()


    Scaffold {
        Column(modifier = Modifier.padding(8.dp, 16.dp, 8.dp, 0.dp)) {
            TabHome(selectedTabIndex = tabPage.ordinal,
                onSelectedTab = {
                    tabPage = it
                }
            )
            HomeScreenContent(menuList = vm.menuList, tabPage = tabPage.name, navController = navController)
        }

    }
}