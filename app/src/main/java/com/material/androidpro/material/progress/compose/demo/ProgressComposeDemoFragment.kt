package com.material.androidpro.material.progress.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.ui.Dimens
import com.material.androidpro.R

class ProgressComposeDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Progress()
                }
            }
        }
    }

    @Composable
    private fun Progress() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = colorResource(id = R.color.secondary)
            )

            CircularProgressIndicator(
                modifier = Modifier.padding(top = Dimens.dp_16)
            )

            CircularProgressIndicator(
                modifier = Modifier.padding(top = Dimens.dp_16),
                strokeWidth = Dimens.dp_30
            )
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            Progress()
        }
    }

}