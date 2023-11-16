package com.material.androidpro.material.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.material.androidpro.R
import com.material.androidpro.common.profile.Profile
import com.material.androidpro.common.profile.ProfileCallback
import com.material.androidpro.common.profile.ProfileItemViewModel
import com.material.androidpro.databinding.ProfileItemBinding

class DialogListAdapter(private val context: Context,
                        items: List<Profile>,
                        private val callback: ProfileCallback) : RecyclerView.Adapter<DialogListAdapter.ViewHolder>() {

    private var itemList : List<Profile>

    init {
        itemList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = DataBindingUtil.inflate<ProfileItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.profile_item, parent, false
        )
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profile = itemList[position]

        val itemViewModel = ProfileItemViewModel(context,
            ContextCompat.getDrawable(context, profile.image), profile.name, profile.shortDes, callback)

        holder.mBinding.vm = itemViewModel
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    fun setList(itemList: ArrayList<Profile>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mBinding: ProfileItemBinding) :
        RecyclerView.ViewHolder(mBinding.root)

}