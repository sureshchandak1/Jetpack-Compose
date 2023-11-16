package com.material.androidpro.material.checkboxes;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.material.androidpro.adapters.ViewModel;
import com.material.androidpro.material.MaterialDesignFragmentDirections;
import com.material.androidpro.material.MaterialModel;

public class CheckboxItemViewModel implements ViewModel {

    public final ObservableField<MaterialModel> mModel = new ObservableField<>();

    public CheckboxItemViewModel(MaterialModel model) {
        mModel.set(model);
    }

    public void itemClick(View view) {
        MaterialModel model = mModel.get();
        if (model != null) {

            NavController navController = Navigation.findNavController(view);
            if (model.getFrom() == CheckboxRetention.DEMO) {
                MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToCheckboxDemoFragment action1 =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCheckboxDemoFragment();
                action1.setTitle(model.getTitle());
                navController.navigate(action1);
            } else if (model.getFrom() == CheckboxRetention.COMPOSE_DEMO) {
                MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToCheckboxComposeDemoFragment action1 =
                        MaterialDesignFragmentDirections.actionMaterialDesignFragmentToCheckboxComposeDemoFragment();
                action1.setTitle(model.getTitle());
                navController.navigate(action1);
            }
        }
    }

    @Override
    public void close() {

    }
}
