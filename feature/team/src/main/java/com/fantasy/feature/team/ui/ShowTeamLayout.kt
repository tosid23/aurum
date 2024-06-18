package com.fantasy.feature.team.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fantasy.data.team.TeamInfoEntity
import com.fantasy.designsystem.theme.theme.md_grey_300
import com.fantasy.designsystem.theme.theme.md_grey_800

@Composable
internal fun ShowTeamLayout(teamInfoEntity: TeamInfoEntity) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(modifier = Modifier.weight(1f)) {
                CurrentPointsLayout(teamInfoEntity)
            }
            Box(modifier = Modifier.weight(1f)) {
                TotalPointsLayout(teamInfoEntity)
            }
        }

    }
}

@Composable
internal fun CurrentPointsLayout(teamInfoEntity: TeamInfoEntity) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp),
        colors = CardDefaults.cardColors()
            .copy(containerColor = md_grey_800, contentColor = md_grey_300),
        onClick = { }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Gameweek ${teamInfoEntity.currentEvent}", fontSize = 12.sp)
            Text(
                text = teamInfoEntity.currentEventPoints.toString(),
                fontSize = 48.sp
            )
            Text(
                text = "Final Points",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
internal fun TotalPointsLayout(teamInfoEntity: TeamInfoEntity) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 8.dp),
        colors = CardDefaults.cardColors()
            .copy(containerColor = md_grey_800, contentColor = md_grey_300),
        onClick = { }
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Total", fontSize = 12.sp)
            Text(
                text = teamInfoEntity.overallPoints.toString(),
                fontSize = 48.sp
            )
            Text(
                text = "Overall Rank ${teamInfoEntity.overallRank}",
                fontSize = 12.sp
            )
        }
    }
}