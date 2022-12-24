package com.example.composeastrosign.graph


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screens(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )

    object Details : Screens(
        route = "DETAILS",
        title = "DETAILS",
        icon = Icons.Default.Person
    )

}