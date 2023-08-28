package com.balaji.compose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimens(
    val dp0: Dp = 0.dp,
    val dp1: Dp = 1.dp,
    val dp2: Dp = 2.dp,
    val dp3: Dp = 3.dp,
    val dp4: Dp = 4.dp,
    val dp5: Dp = 5.dp,
    val dp6: Dp = 6.dp,
    val dp7: Dp = 7.dp,
    val dp8: Dp = 8.dp,
    val dp9: Dp = 9.dp,
    val dp10: Dp = 10.dp,
    val dp11: Dp = 11.dp,
    val dp12: Dp = 12.dp,
    val dp13: Dp = 13.dp,
    val dp14: Dp = 14.dp,
    val dp15: Dp = 15.dp,
    val dp16: Dp = 16.dp,
    val dp17: Dp = 17.dp,
    val dp18: Dp = 18.dp,
    val dp19: Dp = 19.dp,
    val dp20: Dp = 20.dp,
    val dp24: Dp = 24.dp,
    val dp40: Dp = 40.dp,
    val dp60: Dp = 60.dp,
    val dp120: Dp = 120.dp,

    val sp8: TextUnit = 8.sp,
    val sp10: TextUnit = 10.sp,
    val sp12: TextUnit = 12.sp,
    val sp14: TextUnit = 14.sp,
    val sp16: TextUnit = 16.sp,
    val sp18: TextUnit = 18.sp,
    val sp20: TextUnit = 20.sp,
    val sp22: TextUnit = 22.sp,
    val sp24: TextUnit = 24.sp,
    val sp26: TextUnit = 26.sp,

    val default: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
)

val LocalDimens = compositionLocalOf { Dimens() }

val MaterialTheme.dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current