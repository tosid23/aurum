package com.fantasy.feature.team.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fantasy.designsystem.theme.md_black_1000
import com.fantasy.designsystem.theme.ui.DotLoadingLayout
import com.fantasy.feature.team.domain.TeamViewModel
import com.fantasy.feature.team.domain.UiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TeamScreen(
    viewModel: TeamViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = md_black_1000,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Aurum") },
                colors = TopAppBarDefaults.topAppBarColors()
                    .copy(containerColor = md_black_1000)
            )
        },
        floatingActionButton = {

        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (state) {
                is UiState.Empty -> {}
                is UiState.Loading -> {
                    Box(modifier = Modifier.align(Alignment.Center)) {
                        DotLoadingLayout()
                    }
                }

                is UiState.AddTeam -> {
                    Box(modifier = Modifier.align(Alignment.Center)) {
                        AddTeamLayout(viewModel)
                    }
                }

                is UiState.ShowTeam -> {}
            }
        }
    }
}