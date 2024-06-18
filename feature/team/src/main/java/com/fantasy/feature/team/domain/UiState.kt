package com.fantasy.feature.team.domain

import com.fantasy.data.FplTeamInfoEntity

internal sealed class UiState {
    internal data object Empty : UiState()

    internal data object Loading : UiState()

    internal data object AddTeam : UiState()

    internal data class ShowTeam(val team: FplTeamInfoEntity) : UiState()
}