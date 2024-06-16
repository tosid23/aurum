package com.fantasy.aurum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.fantasy.feature.home.homeRoute
import com.fantasy.feature.home.homeScreen

@Composable
fun NavHost() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = homeRoute,
    ) {
        homeScreen()
    }
}