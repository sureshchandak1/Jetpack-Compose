package com.material.androidpro.common.profile.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.databinding.ObservableField;

import com.material.androidpro.adapters.ViewModel;

public class ProfileListItemViewModel implements ViewModel {

    public final ObservableField<Drawable> mImage = new ObservableField<>();
    public final ObservableField<String> mName = new ObservableField<>();

    private final ProfileListCallback mCallback;

    ProfileListItemViewModel(Context context, Drawable image,
                         String name, String shortDes, ProfileListCallback callback) {
        mCallback = callback;
        mImage.set(image);
        mName.set(name);
    }

    public void itemClick(View view) {
        mCallback.itemClick(mImage.get(), mName.get());
    }

    @Override
    public void close() {

    }
}
