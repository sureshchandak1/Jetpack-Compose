package com.material.androidpro.material.bottomappbar;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface BottomAppBarRetention {

    int DEMO = 1;
    int NAVIGATION_BAR = 2;
    int COMPOSE_DEMO = 3;

    @IntDef({DEMO, NAVIGATION_BAR, COMPOSE_DEMO})
    @Retention(RetentionPolicy.SOURCE)
    @interface BottomAppBar {}

}
