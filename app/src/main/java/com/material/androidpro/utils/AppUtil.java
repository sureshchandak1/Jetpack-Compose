package com.material.androidpro.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.DisplayMetrics;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.material.sharedcode.utils.AppUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.snackbar.Snackbar;

public final class AppUtil {

    private AppUtil() {
        throw new IllegalArgumentException(AppUtil.class.getName());
    }

    public static void showToastOnUiThread(Activity activity, String message, int length) {
        activity.runOnUiThread(() -> AppUtils.showToast(activity, message, length));
    }

    public static void setWhiteNavigationBar(Context context, @NonNull Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(metrics);

            GradientDrawable dimDrawable = new GradientDrawable();
            // ...customize your dim effect here

            GradientDrawable navigationBarDrawable = new GradientDrawable();
            navigationBarDrawable.setShape(GradientDrawable.RECTANGLE);
            //navigationBarDrawable.setColor(ContextCompat.getColor(context, R.color.navigationBarColor));

            Drawable[] layers = {dimDrawable, navigationBarDrawable};

            LayerDrawable windowBackground = new LayerDrawable(layers);
            windowBackground.setLayerInsetTop(1, metrics.heightPixels);

            window.setBackgroundDrawable(windowBackground);
        }
    }

    public static void dismissProgressDialog(Activity activity,
                                             @NonNull ProgressDialog progressDialog) {
        activity.runOnUiThread(progressDialog::dismiss);
    }

    public static void showSnackBar(Activity activity,
                                    CoordinatorLayout coordinatorLayout,
                                    String message, int length) {
        activity.runOnUiThread(() -> Snackbar.make(coordinatorLayout, message, length).show());
    }

    public static GoogleMap configMaps(GoogleMap googleMap) {
        // set map type
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Enable / Disable zooming controls
        googleMap.getUiSettings().setZoomControlsEnabled(false);

        // Enable / Disable Compass icon
        googleMap.getUiSettings().setCompassEnabled(true);
        // Enable / Disable Rotate gesture
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        // Enable / Disable zooming functionality
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        //googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        return googleMap;
    }

}
