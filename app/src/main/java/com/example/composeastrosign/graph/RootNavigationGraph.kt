package com.example.composeastrosign.graph

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeastrosign.screens.home.MainScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = Graph.HOME) {
        composable(route = Graph.HOME) {
            MainScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
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
                text = { Text(text = tabPage.name, color = Color.Gray) },
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