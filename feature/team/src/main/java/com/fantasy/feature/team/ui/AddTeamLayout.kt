package com.fantasy.feature.team.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fantasy.designsystem.theme.theme.md_grey_300
import com.fantasy.designsystem.theme.theme.md_grey_700
import com.fantasy.designsystem.theme.theme.md_grey_800
import com.fantasy.designsystem.theme.theme.md_white_1000
import com.fantasy.feature.team.domain.TeamViewModel

@Composable
internal fun AddTeamLayout(vm: TeamViewModel) {
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val keyboardController = LocalSoftwareKeyboardController.current
            var teamId by rememberSaveable { mutableLongStateOf(0L) }

            Text(text = "Add Team", textAlign = TextAlign.Center)
            EnterTeamIdLayout {
                teamId = it
            }
            Button(onClick = {
                keyboardController?.hide()
                vm.getTeamDataFromApi(teamId)
            }) {
                Text(text = "Go")
            }
        }
    }
}

@Composable
private fun EnterTeamIdLayout(teamId: (Long) -> Unit) {
    var inputTeamId by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = md_white_1000,
            unfocusedBorderColor = md_grey_700,
            unfocusedLabelColor = md_grey_700,
            unfocusedLeadingIconColor = md_grey_700
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
        },
        value = inputTeamId,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text("Enter Team ID") },
        onValueChange = {
            inputTeamId = it
            if (inputTeamId.isNotEmpty()) {
                teamId(inputTeamId.toLong())
            } else {
                teamId(0L)
            }
        }
    )


}