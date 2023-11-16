package com.material.androidpro.material.cards.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import javax.inject.Inject

class ProfileRepository @Inject constructor() {

    fun getProfile() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { ProfilePagingSource() }
    ).liveData

}