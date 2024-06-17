package com.fantasy.feature.team.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fantasy.feature.team.domain.repo.TeamRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class TeamViewModel @Inject constructor(
    private val teamRepo: TeamRepo,
) : ViewModel() {

    var uiState = MutableStateFlow<UiState>(UiState.Empty)
        private set

    //private val teamId: Long = 1983972

    init {
        getCurrentTeamData()
    }

    private fun getCurrentTeamData() {
        viewModelScope.launch {
            teamRepo.getFirstTeamFromDb()?.let { teamEntity ->
                uiState.emit(UiState.ShowTeam(teamEntity))
            } ?: run {
                uiState.emit(UiState.AddTeam)
            }
        }
    }

    internal fun getTeamDataFromApi(teamId: Long) {
        viewModelScope.launch {
            uiState.emit(UiState.Loading)
            teamRepo.getTeamDataFromApi(teamId)?.let { teamEntity ->
                uiState.emit(UiState.ShowTeam(teamEntity))
            }
        }
    }

}