package com.material.androidpro.common.places;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface PlacesRetention {

    int INDIA = 1;

    @IntDef({INDIA})
    @Retention(RetentionPolicy.SOURCE)
    @interface Places {}

}
