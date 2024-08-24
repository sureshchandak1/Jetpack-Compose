package com.material.androidpro.compose.ui.musicStreaming.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.material.androidpro.R
import com.material.androidpro.compose.ui.musicStreaming.models.Track
import com.material.androidpro.compose.ui.musicStreaming.ui.theme.dialogColor

@Composable
fun TrackDetailDialog(trackMutableState: MutableState<Track?>, openDialog: MutableState<Boolean>) {
    if (openDialog.value && trackMutableState.value != null) {
        val track = trackMutableState.value!!
        AlertDialog(
            backgroundColor = dialogColor,
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = track.songTitle)
            },
            text = {
                Column {
                    Text(stringResource(R.string.artist) + " " + track.artist)
                    Text(stringResource(R.string.trackNo) + " " + (track.index + 1))
                }
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.padding(12.dp).fillMaxWidth(),
                        onClick = { openDialog.value = false }
                    ) {
                        Text(stringResource(R.string.dismiss))
                    }
                }
            }
        )
    }
}