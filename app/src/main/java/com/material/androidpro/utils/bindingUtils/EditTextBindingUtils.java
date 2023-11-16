package com.material.androidpro.utils.bindingUtils;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public class EditTextBindingUtils {

    private static final String EDIT_TEXT_FOCUS = "editTextFocus";
    private static final String EDIT_TEXT_CLICK_LISTENER = "editTextClickListener";
    private static final String ON_EDITOR_ACTION_LISTENER = "onEditorActionListener";
    private static final String END_ICON_CLICK_LISTENER = "endIconClickListenerTextInputLayout";

    @BindingAdapter({EDIT_TEXT_FOCUS})
    public static void editTextFocus(EditText editText, boolean isFocus) {
        editText.setFocusable(isFocus);
    }

    @BindingAdapter({EDIT_TEXT_CLICK_LISTENER})
    public static void editTextClickListener(EditText editText, View.OnClickListener onClickListener) {
        editText.setOnClickListener(onClickListener);
    }

    @BindingAdapter({ON_EDITOR_ACTION_LISTENER})
    public static void onEditorActionListener(EditText editText, TextView.OnEditorActionListener onEditorActionListener) {
        editText.setOnEditorActionListener(onEditorActionListener);
    }

    @BindingAdapter({END_ICON_CLICK_LISTENER})
    public static void endIconClickListener(TextInputLayout textInputLayout, View.OnClickListener onClickListener) {
        textInputLayout.setEndIconOnClickListener(onClickListener);
    }

}
