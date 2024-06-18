package com.fantasy.feature.team.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fantasy.designsystem.theme.utils.SingleEvent
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

    internal var messageLiveData = MutableLiveData<SingleEvent<String>>()
        private set

    //private val teamId: Long = 1983972

    init {
        getGeneralData()
    }

    private fun getGeneralData() {
        viewModelScope.launch {
            uiState.emit(UiState.Loading)
            if (teamRepo.isGeneralFplDataLoaded().not()) {
                teamRepo.getAllFplDataFromApi()
            }
            getCurrentTeamData()
        }
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
                messageLiveData.postValue(SingleEvent("Welcome ${teamEntity.firstName}"))
                getCurrentTeamData()
            } ?: run {
                messageLiveData.postValue(SingleEvent("Could not find this team, please retry with another one"))
                getCurrentTeamData()
            }
        }
    }

}