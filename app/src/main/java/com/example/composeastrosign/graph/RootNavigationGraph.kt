package com.example.composeastrosign.graph

import androidx.compose.runtime.Composable
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