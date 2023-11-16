package com.material.androidpro.common.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.ui.Dimens
import com.material.androidpro.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileCardItem(profile: Profile) {
    Card(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                PaddingValues(
                    start = Dimens.dp_10,
                    end = Dimens.dp_10,
                    top = Dimens.dp_10,
                    bottom = Dimens.dp_10
                )
            ),
        shape = MaterialTheme.shapes.medium,
        elevation = Dimens.dp_3,
        backgroundColor = colorResource(id = R.color.grey_100)
    ) {
        Row(modifier = Modifier.padding(Dimens.dp_10)) {
            Image(
                painter = painterResource(id = profile.image),
                contentDescription = "Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(Dimens.dp_50)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Dimens.dp_10)
            ) {
                Text(
                    text = profile.name, fontSize = Dimens.sp_18,
                    fontWeight = FontWeight.Medium, fontFamily = FontFamily.SansSerif
                )

                Text(
                    text = stringResource(id = R.string.dummy_des),
                    fontSize = Dimens.sp_14,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(top = Dimens.dp_6)
                )
            }

        }
    }
}