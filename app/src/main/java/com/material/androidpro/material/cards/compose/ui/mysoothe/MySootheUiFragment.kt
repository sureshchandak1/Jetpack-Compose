package com.material.androidpro.material.cards.compose.ui.mysoothe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.material.cards.compose.ui.SearchBar
import com.material.androidpro.ui.Dimens
import com.material.androidpro.ui.theme.AppTheme
import java.util.*

class MySootheUiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MySootheApp()
            }
        }
    }

    @Composable
    fun MySootheApp() {
        AppTheme {
            Scaffold( backgroundColor = colorResource(id = R.color.grey_200),
                bottomBar = { SootheBottomNavigation() }
            ) { padding ->
                HomeScreen(Modifier.padding(padding))
            }
        }
    }

    @Composable
    fun AlignYourBodyElement(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(Dimens.dp_88)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.paddingFromBaseline(
                    top = Dimens.dp_24, bottom = Dimens.dp_8
                )
            )
        }
    }

    @Composable
    fun FavoriteCollectionCard(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = modifier
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(Dimens.dp_192)
            ) {
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(Dimens.dp_56)
                )
                Text(
                    text = stringResource(text),
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(horizontal = Dimens.dp_16)
                )
            }
        }
    }

    @Composable
    fun AlignYourBodyRow(
        modifier: Modifier = Modifier
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.dp_8),
            contentPadding = PaddingValues(horizontal = Dimens.dp_16),
            modifier = modifier
        ) {
            items(items = alignYourBodyData) { item ->
                AlignYourBodyElement(item.drawable, item.text)
            }
        }
    }

    @Composable
    fun FavoriteCollectionsGrid(
        modifier: Modifier = Modifier
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = Dimens.dp_16),
            horizontalArrangement = Arrangement.spacedBy(Dimens.dp_8),
            verticalArrangement = Arrangement.spacedBy(Dimens.dp_8),
            modifier = modifier.height(Dimens.dp_120)
        ) {
            items(favoriteCollectionsData) { item ->
                FavoriteCollectionCard(
                    drawable = item.drawable,
                    text = item.text,
                    modifier = Modifier.height(Dimens.dp_56)
                )
            }
        }
    }

    @Composable
    fun HomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier) {
            Text(
                text = stringResource(title).uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = Dimens.dp_40, bottom = Dimens.dp_8)
                    .padding(horizontal = Dimens.dp_16)
            )
            content()
        }
    }

    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        Column(modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(Dimens.dp_16))
            SearchBar(Modifier.padding(horizontal = Dimens.dp_16))
            HomeSection(title = R.string.align_your_body) {
                AlignYourBodyRow()
            }
            HomeSection(title = R.string.favorite_collections) {
                FavoriteCollectionsGrid()
            }
            Spacer(modifier = Modifier.height(Dimens.dp_16))
        }
    }

    @Composable
    private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            modifier = modifier
        ) {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }

    private val alignYourBodyData = listOf(
        R.drawable.ab1_inversions to R.string.ab1_inversions,
        R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
        R.drawable.ab3_stretching to R.string.ab3_stretching,
        R.drawable.ab4_tabata to R.string.ab4_tabata,
        R.drawable.ab5_hiit to R.string.ab5_hiit,
        R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
    ).map { DrawableStringPair(it.first, it.second) }

    private val favoriteCollectionsData = listOf(
        R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
        R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
        R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
        R.drawable.fc4_self_massage to R.string.fc4_self_massage,
        R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
        R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
    ).map { DrawableStringPair(it.first, it.second) }

    private data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: Int
    )

    @Composable
    @Preview
    fun MySootheAppPreview() {
        MySootheApp()
    }

    @Composable
    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    fun AlignYourBodyElementPreview() {
        AppTheme {
            AlignYourBodyElement(
                text = R.string.ab1_inversions,
                drawable = R.drawable.ab1_inversions,
                modifier = Modifier.padding(Dimens.dp_8)
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun FavoriteCollectionCardPreview() {
        AppTheme {
            FavoriteCollectionCard(
                text = R.string.fc2_nature_meditations,
                drawable = R.drawable.fc2_nature_meditations,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun AlignYourBodyRowPreview() {
        AppTheme {
            AlignYourBodyRow()
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun FavoriteCollectionsGridPreview() {
        AppTheme {
            FavoriteCollectionsGrid()
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun ScreenContentPreview() {
        AppTheme { HomeScreen() }
    }

}