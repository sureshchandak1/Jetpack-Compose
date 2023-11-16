package com.material.androidpro.material.cards.compose.expandable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.material.androidpro.R
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.ui.Dimens

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(profile: Profile) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180F else 0F
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.dp_10)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = MaterialTheme.shapes.medium,
        onClick = {
            expandedState = !expandedState
        },
        elevation = Dimens.dp_3,
        backgroundColor = colorResource(id = R.color.grey_100)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.dp_12)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = profile.image),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(Dimens.dp_40)
                        .clip(CircleShape)
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier
                            .padding(start = Dimens.dp_10)
                            .weight(6f),
                        text = profile.name,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    IconButton(
                        modifier = Modifier
                            .alpha(ContentAlpha.medium)
                            .weight(1f)
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down"
                        )
                    }
                }

            }

            if (expandedState) {
                Text(
                    text = stringResource(id = R.string.dummy_des),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }
}

@Composable
@Preview
fun ExpandableCardPreview() {
    ExpandableCard(Profile(R.drawable.profile_1, "Suresh Chandak"))
}