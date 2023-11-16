package com.material.androidpro.dashboard.home;

import android.content.Context;

import androidx.databinding.ObservableField;

public class ExpandableChildItemViewModel {

    public final ObservableField<String> mChild = new ObservableField<>();

    ExpandableChildItemViewModel(Context context, String child) {
        mChild.set(child);
    }

}
