package com.fantasy.feature.team.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fantasy.feature.team.domain.TeamViewModel
import com.fantasy.feature.team.ui.TeamScreen


const val teamRoute = "aurum/team"


fun NavGraphBuilder.teamScreen() {
    composable(teamRoute) {
        TeamScreen(
            viewModel = hiltViewModel<TeamViewModel>()
        )
    }
}