package com.material.androidpro.material.cards.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.ui.Dimens

class CardComposeDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                cardDemoScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun cardDemoScreen() {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                Card(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.dp_10, vertical = Dimens.dp_10),
                    shape = MaterialTheme.shapes.medium,
                    elevation = Dimens.dp_2
                ) {
                    Row(modifier = Modifier.padding(Dimens.dp_10)) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_1),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(Dimens.dp_64)
                                .clip(CircleShape)
                        )

                        Text(
                            text = stringResource(id = R.string.dummy_des),
                            fontSize = Dimens.sp_14,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier.padding(start = Dimens.dp_10)
                        )
                    }
                }

                Card(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.dp_10, vertical = Dimens.dp_10),
                    shape = MaterialTheme.shapes.medium,
                    elevation = Dimens.dp_2,
                    border = BorderStroke(width = Dimens.dp_1, color = colorResource(id = R.color.secondary))
                ) {
                    Row(modifier = Modifier.padding(Dimens.dp_10)) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_3),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(Dimens.dp_64)
                                .clip(CircleShape)
                        )

                        Text(
                            text = stringResource(id = R.string.dummy_des),
                            fontSize = Dimens.sp_14,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier.padding(start = Dimens.dp_10)
                        )
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        cardDemoScreen()
    }

}