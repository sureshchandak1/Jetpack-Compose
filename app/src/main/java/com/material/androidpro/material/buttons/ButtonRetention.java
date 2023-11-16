package com.material.androidpro.material.buttons;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ButtonRetention {

    int DEMO = 1;
    int SEGMENTED_BUTTONS = 2;
    int TOGGLE_BUTTON = 3;
    int THEMING_BUTTONS = 4;
    int COMPOSE_DEMO = 5;
    int COMPOSE_LOGIN = 6;

    @IntDef({DEMO, SEGMENTED_BUTTONS, TOGGLE_BUTTON, THEMING_BUTTONS,
            COMPOSE_DEMO, COMPOSE_LOGIN})
    @Retention(RetentionPolicy.SOURCE)
    @interface Button {}

}
