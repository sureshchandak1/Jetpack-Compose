package com.material.androidpro.utils.bindingUtils;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

public class BindingUtils {

    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String SET_SWITCH_BUTTON_LISTENER = "setSwitchButtonListener";
    private static final String SET_SWITCH_BUTTON_CHECKED = "setSwitchButtonChecked";
    private static final String SET_UNDERLINE_TEXT = "underlineText";
    private static final String SET_ADAPTER = "setAdapter";
    private static final String SET_ADAPTER_HORIZONTAL = "setAdapterHorizontal";
    private static final String SET_ON_RADIO_BUTTON_LISTENER = "onRadioButtonListener";
    private static final String SET_RADIO_BUTTON_CHECKED = "radioButtonChecked";
    private static final String SET_SPINNER_ADAPTER = "setSpinnerAdapter";
    private static final String SET_SPINNER_LISTENER = "setSpinnerListener";
    private static final String SET_SPINNER_SELECTED_POSITION = "setSpinnerSelectedPosition";
    private static final String SET_CHECKBOX_LISTENER = "setCheckboxListener";

    @BindingAdapter({ERROR_MESSAGE})
    public static void setTextInputLayoutErrorMessage(@NonNull TextInputLayout textInputLayout, String errorMessage) {
        if (!TextUtils.isEmpty(errorMessage)) {
            textInputLayout.setError(errorMessage);
        } else {
            textInputLayout.setError("");
        }
    }

    @BindingAdapter({SET_SWITCH_BUTTON_LISTENER})
    public static void setOnCheckedChangeListener(SwitchCompat switchButton,
                                                  CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (switchButton != null && onCheckedChangeListener != null) {
            switchButton.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    @BindingAdapter({SET_SWITCH_BUTTON_CHECKED})
    public static void setSwitchButtonChecked(SwitchCompat switchButton,
                                              boolean checked) {
        if (switchButton != null) {
            switchButton.setChecked(checked);
        }
    }

    @BindingAdapter({SET_UNDERLINE_TEXT})
    public static void underlineText(TextView textView,
                                     String text) {
        if (textView != null) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            textView.setText(text);
        }
    }

    @BindingAdapter({SET_ADAPTER})
    public static <T extends RecyclerView.ViewHolder> void setAdapter(RecyclerView recyclerView,
                                                                      RecyclerView.Adapter<T> adapter) {
        if (recyclerView != null && adapter != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    @BindingAdapter({SET_ADAPTER_HORIZONTAL})
    public static <T extends RecyclerView.ViewHolder> void setAdapterHorizontal(RecyclerView recyclerView,
                                                                      RecyclerView.Adapter<T> adapter) {
        if (recyclerView != null && adapter != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),
                    RecyclerView.HORIZONTAL, false));
            recyclerView.setAdapter(adapter);
        }
    }

    @BindingAdapter({SET_ON_RADIO_BUTTON_LISTENER})
    public static void onRadioButtonListener(RadioButton radioButton,
                                             RadioButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener != null) {
            radioButton.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    @BindingAdapter({SET_RADIO_BUTTON_CHECKED})
    public static void radioButtonChecked(RadioButton radioButton, boolean isChecked) {
        radioButton.setChecked(isChecked);
    }

    @BindingAdapter({SET_SPINNER_ADAPTER})
    public static void setSpinnerAdapter(Spinner spinner, ArrayAdapter<?> arrayAdapter) {
        if (arrayAdapter != null) {
            spinner.setAdapter(arrayAdapter);
        }
    }

    @BindingAdapter({SET_SPINNER_LISTENER})
    public static void setSpinnerListener(Spinner spinner, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    @BindingAdapter({SET_SPINNER_SELECTED_POSITION})
    public static void setSpinnerSelectedPosition(Spinner spinner, int position) {
        spinner.setSelection(position);
    }

    @BindingAdapter({SET_CHECKBOX_LISTENER})
    public static void setCheckboxListener(CheckBox checkBox, CompoundButton.OnCheckedChangeListener listener) {
        if (listener != null) {
            checkBox.setOnCheckedChangeListener(listener);
        }
    }

}
