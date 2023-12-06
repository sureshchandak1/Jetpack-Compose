package com.material.androidpro.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.material.androidpro.R
import com.material.androidpro.base.BaseFragment
import com.material.androidpro.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment() {

    private lateinit var mBinding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dashboard, container, false
        )

        with(mBinding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }

        val viewModel = DashboardViewModel(requireActivity())
        mBinding.vm = viewModel

        return mBinding.root
    }

}