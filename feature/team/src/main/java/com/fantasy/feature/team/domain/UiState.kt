package com.fantasy.feature.team.domain

import com.fantasy.data.team.TeamInfoEntity

internal sealed class UiState {
    internal data object Empty : UiState()

    internal data object Loading : UiState()

    internal data object AddTeam : UiState()

    internal data class ShowTeam(val team: TeamInfoEntity) : UiState()
}