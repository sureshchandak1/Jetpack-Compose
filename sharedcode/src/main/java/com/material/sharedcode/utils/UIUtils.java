package com.material.sharedcode.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.material.sharedcode.widgets.FontCache;

public class UIUtils {

    public static Typeface getFont(Context context, int mTextStyle) {
        switch (mTextStyle) {
            case 0:
                return FontCache.getQuicksandRegular(context);
            case 1:
                return FontCache.getQuicksandLight(context);
            case 2:
                return FontCache.getQuicksandMedium(context);
            case 3:
                return FontCache.getQuicksandBold(context);
            case 4:
                return FontCache.getCamar(context);
            default:
                return FontCache.getQuicksandRegular(context);
        }
    }
}
