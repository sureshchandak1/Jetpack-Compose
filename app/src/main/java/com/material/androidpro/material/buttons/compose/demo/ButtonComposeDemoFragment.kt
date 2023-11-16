package com.material.androidpro.material.buttons.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class ButtonComposeDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                screenUI()
            }
        }
    }

}

@Composable
private fun screenUI() {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /*TODO*/ }, contentPadding = PaddingValues(
                    start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp
                )
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like")
            }

            OutlinedButton(
                onClick = { /*TODO*/ }, contentPadding = PaddingValues(
                    start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp
                ),
                modifier = Modifier.padding(paddingValues = PaddingValues(top = 16.dp)),
                border = BorderStroke(1.dp, MaterialTheme.colors.secondary)
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = MaterialTheme.colors.secondary
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like", color = MaterialTheme.colors.secondary)
            }

            TextButton(
                onClick = { /*TODO*/ }, contentPadding = PaddingValues(
                    start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp
                ),
                modifier = Modifier.padding(paddingValues = PaddingValues(top = 16.dp))
            ) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = MaterialTheme.colors.secondary
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like", color = MaterialTheme.colors.onBackground)
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    screenUI()
}