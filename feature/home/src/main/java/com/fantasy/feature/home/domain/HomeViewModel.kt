package com.fantasy.feature.home.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fantasy.feature.home.domain.repo.TeamRepo
import com.fantasy.network.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val teamRepo: TeamRepo,
) : ViewModel() {

    private val teamId: Long = 1983972

    init {
        getTeamData()
    }

    internal fun getTeamData() {
        viewModelScope.launch {
            when (val data = teamRepo.getTeamData(teamId)) {
                is Result.Error -> {
                    Timber.e(data.errorMessage)
                }

                is Result.Success -> {
                    Timber.e(data.data.name)
                }
            }
        }
    }

}