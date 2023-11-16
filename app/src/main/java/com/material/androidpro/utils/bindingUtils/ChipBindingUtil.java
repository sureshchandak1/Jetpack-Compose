package com.material.androidpro.utils.bindingUtils;

import android.view.View;
import android.widget.CompoundButton;

import androidx.databinding.BindingAdapter;

import com.google.android.material.chip.Chip;

public final class ChipBindingUtil {

    private ChipBindingUtil() {
        throw new IllegalArgumentException(ChipBindingUtil.class.getName());
    }

    private static final String SET_CHIP_CLICK_LISTENER = "setChipClickListener";
    private static final String SET_CHIP_CLOSE_ICON_CLICK_LISTENER = "setChipCloseIconClickListener";
    private static final String SET_CHIP_CHECKED_CHANGE_LISTENER = "setChipCheckedChangeListener";

    @BindingAdapter({SET_CHIP_CLICK_LISTENER})
    public static void setChipClickListener(Chip chip, View.OnClickListener listener) {
        chip.setOnClickListener(listener);
    }

    @BindingAdapter({SET_CHIP_CLOSE_ICON_CLICK_LISTENER})
    public static void setChipCloseIconClickListener(Chip chip, View.OnClickListener listener) {
        chip.setOnCloseIconClickListener(listener);
    }

    @BindingAdapter({SET_CHIP_CHECKED_CHANGE_LISTENER})
    public static void setChipCheckedChangeListener(Chip chip, CompoundButton.OnCheckedChangeListener listener) {
        chip.setOnCheckedChangeListener(listener);
    }

}
