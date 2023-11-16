package com.material.androidpro.dashboard;

import android.app.Activity;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.material.androidpro.adapters.ViewModel;

public class DashboardItemViewModel implements ViewModel {

    public final ObservableField<DashboardModel> mModel = new ObservableField<>();

    private final Activity mActivity;

    public DashboardItemViewModel(Activity activity, DashboardModel model) {
        mActivity = activity;
        mModel.set(model);
    }

    public void itemClick(View view) {
        DashboardModel model = mModel.get();
        if (model != null) {
            DashboardFragmentDirections.ActionDashboardFragmentToMaterialDesignFragment action =
                    DashboardFragmentDirections.actionDashboardFragmentToMaterialDesignFragment();
            action.setTitle(model.getTitle());
            action.setShortDes(model.getShortDes());
            action.setMaterialType(model.getMaterialType());

            NavController navController = Navigation.findNavController(view);
            //navController.navigate(R.id.action_dashboardFragment_to_materialDesignFragment);
            navController.navigate(action);
        }
    }

    @Override
    public void close() {

    }
}
