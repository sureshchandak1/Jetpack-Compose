package com.material.androidpro.material.cards.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.common.profile.ProfileData

class ProfilePagingSource : PagingSource<Int, Profile>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Profile> {
        val position = params.key ?: 1
        return LoadResult.Page(
            data = ProfileData.profileList(),
            prevKey = if (position == 1) null else position - 1,
            nextKey = position + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Profile>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}