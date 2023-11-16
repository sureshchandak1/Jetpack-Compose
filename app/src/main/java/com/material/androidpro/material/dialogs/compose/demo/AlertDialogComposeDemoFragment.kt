package com.material.androidpro.material.dialogs.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.R

class AlertDialogComposeDemoFragment : Fragment() {

    private val showDialog = mutableStateOf(false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    AlertDialogUi()
                }
            }
        }
    }

    @Composable
    private fun AlertDialogUi() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { showDialog.value = true }) {
                Text(text = "Open Alert Dialog")
                if(showDialog.value) {
                    OpenAlertDialog()
                }
            }
        }
    }

    @Composable
    private fun OpenAlertDialog() {
        AlertDialog(
            title = {
                Text(text = "Aadhavi")
            },
            text = {
                Text(stringResource(id = R.string.dummy_des))
            },
            onDismissRequest = {
                showDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            AlertDialogUi()
        }
    }

}