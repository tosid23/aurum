package com.fantasy.aurum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.fantasy.feature.team.navigation.teamRoute
import com.fantasy.feature.team.navigation.teamScreen

@Composable
fun NavHost() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = teamRoute,
    ) {
        teamScreen()
    }
}