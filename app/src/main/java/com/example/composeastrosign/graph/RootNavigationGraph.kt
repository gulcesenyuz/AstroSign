package com.example.composeastrosign.graph

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeastrosign.ui.screens.details.DetailsScreen
import com.example.composeastrosign.ui.screens.home.HomeScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = "details/{day}/{sign}/{icon}",
            arguments = listOf(
                navArgument(name = "day") { NavType.StringType },
                navArgument(name = "sign") { NavType.StringType },
                navArgument(name = "icon") { NavType.StringType },
            )
        ) {backStackEntry ->
            DetailsScreen(
                day = backStackEntry.arguments?.getString("sign")!!,
                sign = backStackEntry.arguments?.getString("day")!!,
                icon = backStackEntry.arguments?.getString("icon")!!,
            )
        }
    }
}


enum class TabPage(val icon: ImageVector) {
    Today(Icons.Default.Home),
    Tomorrow(Icons.Default.Home),
    Yesterday(Icons.Default.Home),
}

@Composable
fun TabHome(selectedTabIndex: Int, onSelectedTab: (TabPage) -> Unit) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        indicator = { TabIndicator(tabPosition = it, index = selectedTabIndex) }

    ) {
        TabPage.values().forEachIndexed { index, tabPage ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSelectedTab(tabPage) },
                text = { Text(text = tabPage.name, color = Color.Gray, fontSize = 12.sp, fontWeight = FontWeight.Normal) },
            )
        }

    }

}

@Composable
fun TabIndicator(tabPosition: List<TabPosition>, index: Int) {
    val width = tabPosition[index].width
    val offsetX = tabPosition[index].left

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset(x = offsetX)
            .width(width)
            .padding(4.dp)
            .fillMaxSize()
            .border(BorderStroke(2.dp, Color.Magenta), RoundedCornerShape(4.dp))
    )


}