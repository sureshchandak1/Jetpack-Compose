package com.material.androidpro.material.switchs.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.ui.Dimens

class SwitchComposeDemoFragment : Fragment() {

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
                    SwitchCompose()
                }
            }
        }
    }

    @Composable
    private fun SwitchCompose() {

        var checked by remember { mutableStateOf(true) }

        val icon: (@Composable () -> Unit)? = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(Dimens.dp_12),
                )
            }
        } else {
            null
        }

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Switch(
                modifier = Modifier.semantics { contentDescription = "Demo" },
                checked = checked,
                onCheckedChange = { checked = it }
            )

        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            SwitchCompose()
        }
    }


}