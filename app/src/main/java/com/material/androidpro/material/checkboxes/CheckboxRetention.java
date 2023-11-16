package com.material.androidpro.material.checkboxes;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface CheckboxRetention {

    int DEMO = 1;
    int COMPOSE_DEMO = 2;

    @IntDef({DEMO, COMPOSE_DEMO})
    @Retention(RetentionPolicy.SOURCE)
    @interface Checkbox {}

}
