package com.material.androidpro.material.cards.paging

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardPagingViewModel @Inject constructor(private val mRepository: ProfileRepository) : ViewModel() {

    val profileList = mRepository.getProfile()

}