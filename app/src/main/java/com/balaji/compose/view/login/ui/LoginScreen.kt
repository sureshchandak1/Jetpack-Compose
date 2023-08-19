package com.balaji.compose.view.login.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.balaji.compose.ui.theme.ComposeTheme
import com.balaji.compose.ui.theme.FontRetention
import com.balaji.compose.ui.theme.fontQuicksand

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontFamily = fontQuicksand(FontRetention.QUICKSAND_BOLD)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposeTheme {
        LoginScreen("Android")
    }
}