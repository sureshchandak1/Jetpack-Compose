package com.balaji.compose.view.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.balaji.compose.R
import com.balaji.compose.ui.theme.ComposeTheme
import com.balaji.compose.ui.theme.dimens

@Composable
fun SplashScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (logo) = createRefs()

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Compose",
            modifier = Modifier
                .width(MaterialTheme.dimens.dp120)
                .height(MaterialTheme.dimens.dp120)
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