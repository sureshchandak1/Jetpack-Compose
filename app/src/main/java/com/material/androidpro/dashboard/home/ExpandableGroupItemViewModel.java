package com.material.androidpro.dashboard.home;

import androidx.databinding.ObservableField;

public class ExpandableGroupItemViewModel {

    public final ObservableField<Integer> mImage = new ObservableField<>();
    public final ObservableField<String> mTitle = new ObservableField<>();

    ExpandableGroupItemViewModel(int image, String title) {
        mImage.set(image);
        mTitle.set(title);
    }

}
