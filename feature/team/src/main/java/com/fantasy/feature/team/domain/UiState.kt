package com.fantasy.feature.team.domain

import com.fantasy.datastore.data.TeamEntity

internal sealed class UiState {
    internal data object Empty : UiState()

    internal data object Loading : UiState()

    internal data object AddTeam : UiState()

    internal data class ShowTeam(val team: TeamEntity) : UiState()
}