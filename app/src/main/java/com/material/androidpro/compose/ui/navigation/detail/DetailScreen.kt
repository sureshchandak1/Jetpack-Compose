package com.material.androidpro.compose.ui.navigation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.material.androidpro.compose.ui.navigation.Screen
import com.material.androidpro.ui.Dimens

@Composable
fun DetailScreen(navController: NavController, name: String?) {
    Surface {
        ConstraintLayout {
            val (backImage, detailName) = createRefs()

            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        // navController.popBackStack()
                        navController.navigate(Screen.MainScreen.route) {
                            popUpTo(Screen.MainScreen.route) {
                                inclusive = true
                            }
                        }
                    }
                    .padding(Dimens.dp_16)
                    .constrainAs(backImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().constrainAs(detailName) {
                    top.linkTo(backImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            ) {
                Text(text = "Hello $name")
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(navController = rememberNavController(), name = "John")
}