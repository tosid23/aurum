package com.fantasy.feature.team.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fantasy.designsystem.theme.theme.md_black_1000
import com.fantasy.designsystem.theme.theme.md_blue_grey_900
import com.fantasy.designsystem.theme.theme.md_grey_900
import com.fantasy.designsystem.theme.ui.DotLoadingLayout
import com.fantasy.feature.team.domain.TeamViewModel
import com.fantasy.feature.team.domain.UiState
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TeamScreen(
    viewModel: TeamViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val messages by viewModel.messageLiveData.observeAsState()
    messages?.getContentIfNotHandled()?.let {
        scope.launch {
            snackbarHostState.showSnackbar(it)
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = md_grey_900,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    when (state) {
                        is UiState.ShowTeam -> {
                            Text(text = (state as UiState.ShowTeam).team.name)
                        }

                        else -> {
                            Text(text = "Aurum")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors()
                    .copy(containerColor = md_grey_900)
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

                is UiState.ShowTeam -> {
                    ShowTeamLayout((state as UiState.ShowTeam).team)
                }
            }
        }
    }
}