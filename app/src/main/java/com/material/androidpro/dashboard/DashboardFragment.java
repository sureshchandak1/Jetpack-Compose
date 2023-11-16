package com.material.androidpro.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.material.androidpro.R;
import com.material.androidpro.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
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
        FragmentDashboardBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_dashboard, container, false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DashboardViewModel viewModel = new DashboardViewModel(getActivity());
        binding.setVm(viewModel);

        return binding.getRoot();
    }
}