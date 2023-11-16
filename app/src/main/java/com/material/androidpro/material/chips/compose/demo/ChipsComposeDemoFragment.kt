package com.material.androidpro.material.chips.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.ui.Dimens

class ChipsComposeDemoFragment : Fragment() {

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
                    chipDemo()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun chipDemo() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Chip(
                colors = ChipDefaults.chipColors(
                    backgroundColor = colorResource(id = R.color.background),
                    contentColor = colorResource(id = R.color.primary)
                ),
                onClick = {},
                border = BorderStroke(Dimens.dp_1, colorResource(id = R.color.outline))
            ) {
                Row(modifier = Modifier.padding(Dimens.dp_10)) {
                    Text(
                        text = "Chip 1",
                        modifier = Modifier.padding(start = Dimens.dp_10)
                    )
                }
            }

            Chip(
                colors = ChipDefaults.chipColors(
                    backgroundColor = colorResource(id = R.color.background),
                    contentColor = colorResource(id = R.color.primary)
                ),
                modifier = Modifier.padding(top = Dimens.dp_10),
                onClick = {},
                border = BorderStroke(Dimens.dp_1, colorResource(id = R.color.outline))
            ) {
                Row(modifier = Modifier.padding(Dimens.dp_10)) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Done",
                        modifier = Modifier
                            .width(Dimens.dp_16)
                            .height(Dimens.dp_16),
                        tint = colorResource(id = R.color.secondary)
                    )
                    Text(
                        text = "Chip 2",
                        modifier = Modifier.padding(start = Dimens.dp_10)
                    )
                }
            }

            Chip(
                colors = ChipDefaults.chipColors(
                    backgroundColor = colorResource(id = R.color.secondaryContainer),
                    contentColor = colorResource(id = R.color.onSecondaryContainer)
                ),
                modifier = Modifier.padding(top = Dimens.dp_10),
                onClick = {},
                border = BorderStroke(Dimens.dp_1, colorResource(id = R.color.secondary))
            ) {
                Row(modifier = Modifier.padding(Dimens.dp_10)) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Done",
                        modifier = Modifier
                            .width(Dimens.dp_16)
                            .height(Dimens.dp_16),
                        tint = colorResource(id = R.color.secondary)
                    )
                    Text(
                        text = "Chip 3",
                        modifier = Modifier.padding(start = Dimens.dp_10)
                    )
                }
            }

            Chip(
                colors = ChipDefaults.chipColors(
                    backgroundColor = colorResource(id = R.color.primary),
                    contentColor = colorResource(id = R.color.onPrimary)
                ),
                modifier = Modifier.padding(top = Dimens.dp_10),
                onClick = {},
            ) {
                Row(modifier = Modifier.padding(Dimens.dp_10)) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Done",
                        modifier = Modifier
                            .width(Dimens.dp_16)
                            .height(Dimens.dp_16),
                        tint = colorResource(id = R.color.onPrimary)
                    )
                    Text(
                        text = "Chip 4",
                        modifier = Modifier.padding(start = Dimens.dp_10)
                    )
                }
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Dimens.dp_8),
                contentPadding = PaddingValues(horizontal = Dimens.dp_16),
                modifier = Modifier.padding(top = Dimens.dp_10)
            ) {
                items(items = chipList) { item ->
                    chip(text = item)
                }
            }
        }

    }

    private val chipList = listOf(
        "Chip 1",
        "Chip 2",
        "Chip 3",
        "Chip 4",
        "Chip 5",
        "Chip 6",
        "Chip 7",
        "Chip 8",
        "Chip 9",
        "Chip 10"
    )

    private data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: Int
    )

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun chip(text: String) {
        Chip(
            colors = ChipDefaults.chipColors(
                backgroundColor = colorResource(id = R.color.background),
                contentColor = colorResource(id = R.color.onBackground)
            ),
            onClick = {},
            border = BorderStroke(Dimens.dp_1, colorResource(id = R.color.outline))
        ) {
            Row(modifier = Modifier.padding(Dimens.dp_10)) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Done",
                    modifier = Modifier
                        .width(Dimens.dp_16)
                        .height(Dimens.dp_16),
                    tint = colorResource(id = R.color.secondary)
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = Dimens.dp_10)
                )
            }
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            chipDemo()
        }
    }

}