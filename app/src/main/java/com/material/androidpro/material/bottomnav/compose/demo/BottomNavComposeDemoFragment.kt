package com.material.androidpro.material.bottomnav.compose.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.R
import com.material.androidpro.common.compose.ProfileCardItem
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.common.profile.ProfileData
import com.material.androidpro.ui.Dimens

class BottomNavComposeDemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    BottomNav()
                }
            }
        }
    }

    @Composable
    private fun BottomNav() {
        var selectedItem by remember { mutableStateOf(0) }

        val profileList: List<Profile> = ProfileData.profileList()
        val items = listOf("Songs", "Artists", "Playlists")

        LazyColumn(
            contentPadding = PaddingValues(bottom = Dimens.dp_80),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = profileList) { profile ->
                ProfileCardItem(profile = profile)
            }
        }

        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Bottom),
            backgroundColor = colorResource(id = R.color.background),
            elevation = Dimens.dp_10,
            contentPadding = PaddingValues(Dimens.dp_0)
        ) {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.Bottom),
                backgroundColor = colorResource(id = R.color.background)
            ) {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(item) }
                    )
                }
            }
        }

    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            BottomNav()
        }
    }

}