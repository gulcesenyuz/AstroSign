package com.example.composeastrosign.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeastrosign.graph.TabHome
import com.example.composeastrosign.graph.TabPage
import com.example.composeastrosign.ui.screens.main.MainViewModel
import com.google.accompanist.pager.*
/*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {

    var tabPage by remember {
        mutableStateOf(TabPage.Today)
    }
    val vm: MainViewModel = hiltViewModel()
    vm.createMenuItemModel()


    Scaffold{
       Column(modifier = Modifier.padding(8.dp,200.dp,8.dp,0.dp)) {
           TabHome(selectedTabIndex = tabPage.ordinal,
               onSelectedTab = {
                   tabPage = it
               }
           )
          HomeNavigationGraph(navController = navController,tabPage.name,vm.menuList)
       }

    }
}
 */
