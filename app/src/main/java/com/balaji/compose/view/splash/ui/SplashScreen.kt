package com.balaji.compose.view.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.balaji.compose.R
import com.balaji.compose.ui.theme.ComposeTheme

@Composable
fun SplashScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (logo) = createRefs()

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Compose",
            modifier = Modifier.width(120.dp).height(120.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ComposeTheme {
        SplashScreen()
    }
}