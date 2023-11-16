package com.material.androidpro.material;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.material.androidpro.MaterialRetention;
import com.material.androidpro.R;
import com.material.androidpro.databinding.FragmentMaterialDesignBinding;

public class MaterialDesignFragment extends Fragment {

    public MaterialDesignFragment() {
        // Required empty public constructor
    }

    public static MaterialDesignFragment newInstance() {
        MaterialDesignFragment fragment = new MaterialDesignFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private FragmentMaterialDesignBinding mBinding;
    private String mTitle;
    private String mShortDes;
    private @MaterialRetention.Material int materialType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            MaterialDesignFragmentArgs args = MaterialDesignFragmentArgs.fromBundle(getArguments());
            mTitle = args.getTitle();
            mShortDes = args.getShortDes();
            materialType = args.getMaterialType();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_material_design, container, false);

        MaterialDesignViewModel viewModel = new MaterialDesignViewModel(materialType);
        mBinding.setVm(viewModel);
        viewModel.shortDes.set(mShortDes);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*mBinding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mBinding.toolbar.setNavigationOnClickListener(view1 -> {
            NavController navController = Navigation.findNavController(view);
            NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.dashboardFragment, true).build();
            navController.navigate(R.id.action_materialDesignFragment_to_dashboardFragment, null, navOptions);
        });*/

    }
}