package com.material.androidpro.compose.ui.petlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.material.androidpro.compose.ui.data.PetData

class PetListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ScreenUI()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ScreenUI() {
    Scaffold {
        LazyColumn {
            items(
                items = PetData.petList,
                key = { it.uniqueId }
            ) {
                PerItemCard(
                    it,
                    onItemClicked = { pet ->

                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    ScreenUI()
}