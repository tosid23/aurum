package com.fantasy.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val homeRoute = "aurum/home"


fun NavGraphBuilder.homeScreen() {
    composable(homeRoute) {
        HomeScreen()
    }
}