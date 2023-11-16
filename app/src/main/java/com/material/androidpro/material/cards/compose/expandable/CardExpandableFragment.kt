package com.material.androidpro.material.cards.compose.expandable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.common.profile.ProfileData
import com.material.androidpro.ui.Dimens

class CardExpandableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {
                    itemLazyColumn()
                }
            }
        }
    }

    @Composable
    private fun itemLazyColumn() {
        val profileList: List<Profile> = ProfileData.profileList()

        LazyColumn(
            contentPadding = PaddingValues(bottom = Dimens.dp_80),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = profileList) { profile ->
                ExpandableCard(profile = profile)
            }
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        Surface(modifier = Modifier.fillMaxSize()) {
            itemLazyColumn()
        }
    }

}