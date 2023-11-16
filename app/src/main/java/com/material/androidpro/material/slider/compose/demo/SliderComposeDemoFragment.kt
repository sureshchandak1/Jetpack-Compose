package com.material.androidpro.material.slider.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.ui.Dimens

class SliderComposeDemoFragment : Fragment() {

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
                    CreateSlider()
                }
            }
        }
    }

    @Composable
    private fun CreateSlider() {

        var sliderPosition by remember { mutableStateOf(0f) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = sliderPosition.toString())
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                steps = 5,
                colors = SliderDefaults.colors(
                    thumbColor = colorResource(id = R.color.secondary),
                    activeTrackColor = colorResource(id = R.color.secondary)
                ),
                modifier = Modifier.padding(start = Dimens.dp_16, end = Dimens.dp_16)
            )
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            CreateSlider()
        }
    }


}