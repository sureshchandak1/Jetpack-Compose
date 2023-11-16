package com.material.androidpro.material.buttons;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.material.androidpro.adapters.ViewModel;
import com.material.androidpro.material.MaterialDesignFragmentDirections;
import com.material.androidpro.material.MaterialModel;

public class ButtonItemViewModel implements ViewModel {

    public final ObservableField<MaterialModel> mModel = new ObservableField<>();

    public ButtonItemViewModel(MaterialModel model) {
        mModel.set(model);
    }

    public void itemClick(View view) {
        MaterialModel model = mModel.get();
        if (model != null) {

            NavController navController = Navigation.findNavController(view);
            switch (model.getFrom()) {
                case ButtonRetention.DEMO:
                    MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToButtonDemoFragment action1 =
                            MaterialDesignFragmentDirections.actionMaterialDesignFragmentToButtonDemoFragment();
                    action1.setTitle(model.getTitle());
                    navController.navigate(action1);
                    break;
                case ButtonRetention.SEGMENTED_BUTTONS:
                    break;
                case ButtonRetention.TOGGLE_BUTTON:
                    MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToButtonToggleFragment action2 =
                            MaterialDesignFragmentDirections.actionMaterialDesignFragmentToButtonToggleFragment();
                    action2.setTitle(model.getTitle());
                    navController.navigate(action2);
                    break;
                case ButtonRetention.THEMING_BUTTONS:
                    MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToButtonThemingFragment action3 =
                            MaterialDesignFragmentDirections.actionMaterialDesignFragmentToButtonThemingFragment();
                    action3.setTitle(model.getTitle());
                    navController.navigate(action3);
                    break;
                case ButtonRetention.COMPOSE_DEMO:
                    MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToButtonComposeDemoFragment action4 =
                            MaterialDesignFragmentDirections.actionMaterialDesignFragmentToButtonComposeDemoFragment();
                    action4.setTitle(model.getTitle());
                    navController.navigate(action4);
                    break;
                case ButtonRetention.COMPOSE_LOGIN:
                    MaterialDesignFragmentDirections.ActionMaterialDesignFragmentToButtonComposeLoginFragment action5 =
                            MaterialDesignFragmentDirections.actionMaterialDesignFragmentToButtonComposeLoginFragment();
                    action5.setTitle("Login");
                    navController.navigate(action5);
                    break;
            }
        }
    }

    @Override
    public void close() {

    }
}
