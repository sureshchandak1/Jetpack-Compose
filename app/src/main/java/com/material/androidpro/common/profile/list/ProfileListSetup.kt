package com.material.androidpro.common.profile.list

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.material.androidpro.R
import com.material.androidpro.adapters.ViewModel
import com.material.androidpro.common.EmptyItemViewModel
import com.material.androidpro.common.profile.MonthItemViewModel

class ProfileListSetup(context: Context, recyclerView: RecyclerView, callback: ProfileListCallback) {

    init {
        setAdapter(context, recyclerView, callback)
    }

    private fun setAdapter(context: Context, recyclerView: RecyclerView, callback: ProfileListCallback) {
        val viewModels: MutableList<ViewModel> = ArrayList()

        viewModels.add(MonthItemViewModel("June"))
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_1), "Aadhavi", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_3), "Divya", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_4), "Jivika", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_5), "Kavya", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_6), "Sarika", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_7), "Lavanya", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_9), "Uma", "",
                callback
            )
        )
        viewModels.add(MonthItemViewModel("September"))
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_10), "Emma", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_11), "Sophia", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_12), "Evelyn", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_13), "Camila", "",
                callback
            )
        )
        viewModels.add(MonthItemViewModel("November"))
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_14), "Scarlett", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_15), "Penelope", "",
                callback
            )
        )
        viewModels.add(MonthItemViewModel("January"))
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_16), "Madison", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_17), "Madison", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_18), "Benjamin", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_19), "Theodore", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_20), "Jack", "",
                callback
            )
        )
        viewModels.add(MonthItemViewModel("February"))
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_21), "Logan", "",
                callback
            )
        )
        viewModels.add(
            ProfileListItemViewModel(
                context,
                ContextCompat.getDrawable(context, R.drawable.profile_22), "Joseph", "",
                callback
            )
        )

        viewModels.add(EmptyItemViewModel())

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ProfileListAdapter(viewModels)
        recyclerView.adapter = adapter
    }

}