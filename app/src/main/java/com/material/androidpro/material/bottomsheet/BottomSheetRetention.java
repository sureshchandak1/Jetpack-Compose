package com.material.androidpro.material.bottomsheet;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface BottomSheetRetention {

    int DEMO = 1;
    int MODAL = 2;
    int PERSISTENT = 3;
    int FULL_SCREEN = 4;

    @IntDef({DEMO, MODAL, PERSISTENT, FULL_SCREEN})
    @Retention(RetentionPolicy.SOURCE)
    @interface BottomSheet {}

}
