package com.balaji.compose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

@Composable
fun fontQuicksand(@FontRetention.Font font: Int = FontRetention.QUICKSAND_REGULAR) : FontFamily {
    return when (font) {
        FontRetention.QUICKSAND_REGULAR -> { FontFamily(fontQuicksandRegular()) }
        FontRetention.QUICKSAND_LIGHT -> { FontFamily(fontQuicksandLight()) }
        FontRetention.QUICKSAND_MEDIUM -> { FontFamily(fontQuicksandMedium()) }
        FontRetention.QUICKSAND_BOLD -> { FontFamily(fontQuicksandBold()) }
        else -> { FontFamily(fontQuicksandRegular()) }
    }
}

@Composable
fun fontQuicksandRegular() = Font(assetManager = LocalContext.current.assets, path = "fonts/Quicksand-Regular.ttf")

@Composable
fun fontQuicksandLight() = Font(assetManager = LocalContext.current.assets, path = "fonts/Quicksand-Light.ttf")

@Composable
fun fontQuicksandMedium() = Font(assetManager = LocalContext.current.assets, path = "fonts/Quicksand-Medium.ttf")

@Composable
fun fontQuicksandBold() = Font(assetManager = LocalContext.current.assets, path = "fonts/Quicksand-Bold.ttf")

