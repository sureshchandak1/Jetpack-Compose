package com.material.androidpro.material.bottomsheet;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.material.androidpro.adapters.ViewModel;
import com.material.androidpro.material.MaterialDesignFragmentDirections;
import com.material.androidpro.material.MaterialModel;

public class BottomSheetItemViewModel implements ViewModel {

    public final ObservableField<MaterialModel> mModel = new ObservableField<>();

    public BottomSheetItemViewModel(MaterialModel model) {
        mModel.set(model);
    }

    public void itemClick(View view) {
        MaterialModel model = mModel.get();
        if (model != null) {

            NavController navController = Navigation.findNavController(view);
            if (model.getFrom() == BottomSheetRetention.DEMO) {
                MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToBottomSheetDemoFragment action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomSheetDemoFragment();
                action.setTitle(model.getTitle());
                navController.navigate(action);
            } else if (model.getFrom() == BottomSheetRetention.MODAL) {
                MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToBottomSheetModalFragment action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomSheetModalFragment();
                action.setTitle(model.getTitle());
                navController.navigate(action);
            } else if (model.getFrom() == BottomSheetRetention.PERSISTENT) {
                MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToBottomSheetPersistentFragment action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomSheetPersistentFragment();
                action.setTitle(model.getTitle());
                navController.navigate(action);
            } else if (model.getFrom() == BottomSheetRetention.FULL_SCREEN) {
                MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToBottomSheetFullScreenFragment action =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToBottomSheetFullScreenFragment();
                action.setTitle(model.getTitle());
                navController.navigate(action);
            }
        }
    }

    @Override
    public void close() {

    }
}
