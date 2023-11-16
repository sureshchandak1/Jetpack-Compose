package com.material.androidpro.dashboard.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.material.androidpro.R;
import com.material.androidpro.base.BaseFragment;
import com.material.androidpro.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_home, container, false);

        HomeViewModel viewModel = new HomeViewModel(getActivity(), binding.expandableListView);
        binding.setVm(viewModel);

        return binding.getRoot();
    }

    @Override
    public Fragment getCurrentFragment() {
        return null;
    }
}