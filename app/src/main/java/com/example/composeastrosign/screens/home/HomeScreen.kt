package com.example.composeastrosign.screens.home

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(name: String, onClick: () -> Unit, tabPage: String) {
      HomeScreenContent (tabPage,onClick)
}