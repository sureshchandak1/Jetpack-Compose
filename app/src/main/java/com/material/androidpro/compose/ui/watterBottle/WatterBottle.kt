package com.material.androidpro.compose.ui.watterBottle

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.material.androidpro.ui.Dimens

@Composable
fun WatterBottle(
    modifier: Modifier = Modifier,
    totalWaterAmount: Int,
    unit: String,
    usedWaterAmount: Int,
    waterWavesColor: Color = Color(0xff279EFF),
    bottleColor: Color = Color.White,
    capColor: Color = Color(0xFF0065B9)
) {

    val waterPercentage = animateFloatAsState(
        targetValue = (usedWaterAmount.toFloat() / totalWaterAmount.toFloat()),
        label = "Water Waves animation",
        animationSpec = tween(durationMillis = 1000)
    ).value

    val usedWaterAmountAnimation = animateIntAsState(
        targetValue = usedWaterAmount,
        label = "Used water amount animation",
        animationSpec = tween(durationMillis = 1000)
    ).value

    Box(modifier = Modifier
        .width(Dimens.dp_200)
        .height(Dimens.dp_600)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            val capWidth = size.width * 0.55F
            val capHeight = size.height * 0.13F

            val bottleBodyPath = Path().apply {
                moveTo(x = width * 0.3F, y = height * 0.1F)
                lineTo(x = width * 0.3F, y = height * 0.2F)
                quadraticBezierTo(
                    x1 = 0F, y1 = height * 0.3F,
                    x2 = 0F, y2 = height * 0.4F
                )
                lineTo(x = 0F, y = height * 0.95F)
                quadraticBezierTo(
                    x1 = 0F, y1 = height,
                    x2 = width * 0.05F, y2 = height
                )
                lineTo(x = width * 0.95F, y = height)
                quadraticBezierTo(
                    x1 = width, y1 = height,
                    x2 = width, y2 = height * 0.95F
                )
                lineTo(x = width, y = height * 0.4F)
                quadraticBezierTo(
                    x1 = width, y1 = height * 0.3F,
                    x2 = width * 0.7F, y2 = height * 0.2F
                )
                lineTo(x = width * 0.7F, y = height * 0.1F)

                close()
            }

            clipPath(bottleBodyPath) {
                drawRect(
                    color = bottleColor,
                    size = size
                )

                val waterWavesYPosition = (1 - waterPercentage) * size.height
                val waterPath = Path().apply {
                    moveTo(x = 0F, y = waterWavesYPosition)
                    lineTo(x = size.width, y = waterWavesYPosition)
                    lineTo(x = size.width, y = size.height)
                    lineTo(x = 0F, y = size.height)
                    close()
                }

                drawPath(
                    path = waterPath,
                    color = waterWavesColor
                )
            }

            drawRoundRect(
                color = capColor,
                size = Size(capWidth, capHeight),
                topLeft = Offset(size.width / 2 - capWidth / 2F, 0F),
                cornerRadius = CornerRadius(45F, 45F)
            )
        }

        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = if (waterPercentage > 0.5F) bottleColor else waterWavesColor,
                    fontSize = Dimens.sp_44
                )
            ) {
                append(usedWaterAmountAnimation.toString())
            }
            withStyle(
                style = SpanStyle(
                    color = if (waterPercentage > 0.5F) bottleColor else waterWavesColor,
                    fontSize = Dimens.sp_22
                )
            ) {
                append(" ")
                append(unit)
            }
        }
        
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text)
        }
    }

}


@Preview
@Composable
fun WaterBottlePreview() {
    WatterBottle(
        totalWaterAmount = 2500,
        unit = "ml",
        usedWaterAmount = 120
    )
}