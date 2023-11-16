package com.material.sharedcode.widgets;

import android.content.Context;
import android.graphics.Typeface;

public class FontCache {

    private static Typeface quicksandRegular, quicksandLight, quicksandBold, quicksandMedium;
    private static Typeface camar;

    public static Typeface getCamar(Context context) {
        if (camar == null) {
            camar = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/Camar.otf");
        }
        return camar;
    }

    public static Typeface getQuicksandRegular(Context context) {
        if (quicksandRegular == null) {
            quicksandRegular = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/Quicksand-Regular.ttf");
        }
        return quicksandRegular;
    }

    public static Typeface getQuicksandLight(Context context) {
        if (quicksandLight == null) {
            quicksandLight = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/Quicksand-Light.ttf");
        }
        return quicksandLight;
    }

    public static Typeface getQuicksandBold(Context context) {
        if (quicksandBold == null) {
            quicksandBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/Quicksand-Bold.ttf");
        }
        return quicksandBold;
    }

    public static Typeface getQuicksandMedium(Context context) {
        if (quicksandMedium == null) {
            quicksandMedium = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/Quicksand-Medium.ttf");
        }
        return quicksandMedium;
    }
}
