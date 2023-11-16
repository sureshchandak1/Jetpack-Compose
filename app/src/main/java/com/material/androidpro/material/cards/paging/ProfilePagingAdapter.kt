package com.material.androidpro.material.cards.paging

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.material.androidpro.R
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileItemViewModel
import com.material.androidpro.databinding.ProfileItemBinding

class ProfilePagingAdapter(private val mContext: Context,
                           private val mCallback: ProfileCallback) :
    PagingDataAdapter<Profile, ProfilePagingAdapter.ProfileViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binging: ProfileItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.profile_item, parent, false)
        return ProfileViewHolder(binging)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = getItem(position)
        val itemViewModel = profile?.let {
            ProfileItemViewModel(
                mContext,
                ContextCompat.getDrawable(mContext, it.image), it.name, it.shortDes,
                mCallback
            )
        }

        holder.mItemBinding.vm = itemViewModel
    }

    class ProfileViewHolder(itemBinding: ProfileItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val mItemBinding: ProfileItemBinding
        init {
            mItemBinding = itemBinding
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Profile>() {

            override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
                return oldItem == newItem
            }

        }
    }

}