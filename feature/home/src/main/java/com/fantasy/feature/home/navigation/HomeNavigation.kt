package com.fantasy.feature.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fantasy.feature.home.domain.HomeViewModel
import com.fantasy.feature.home.ui.HomeScreen


const val homeRoute = "aurum/home"


fun NavGraphBuilder.homeScreen() {
    composable(homeRoute) {
        HomeScreen(
            viewModel = hiltViewModel<HomeViewModel>()
        )
    }
}