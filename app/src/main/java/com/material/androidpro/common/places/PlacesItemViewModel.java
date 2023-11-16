package com.material.androidpro.common.places;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.material.androidpro.adapters.ViewModel;
import com.material.sharedcode.utils.AppUtils;

public class PlacesItemViewModel implements ViewModel {

    public final ObservableField<Drawable> mImage = new ObservableField<>();
    public final ObservableField<String> mPlaces = new ObservableField<>();
    public final ObservableField<String> mCity = new ObservableField<>();

    private final Context mContext;

    PlacesItemViewModel(Context context, Drawable image, String places, String city) {
        mContext = context;
        mImage.set(image);
        mPlaces.set(places);
        mCity.set(city);
    }

    public void itemClick(View view) {
        AppUtils.showToast(mContext, mPlaces.get(), Toast.LENGTH_SHORT);
    }

    @Override
    public void close() {

    }
}
