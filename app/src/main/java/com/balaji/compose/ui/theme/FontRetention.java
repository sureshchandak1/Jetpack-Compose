package com.balaji.compose.ui.theme;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface FontRetention {

    int QUICKSAND_REGULAR = 1;
    int QUICKSAND_LIGHT = 2;
    int QUICKSAND_MEDIUM = 3;
    int QUICKSAND_BOLD = 4;

    @IntDef({QUICKSAND_REGULAR, QUICKSAND_LIGHT, QUICKSAND_MEDIUM, QUICKSAND_BOLD})
    @Retention(RetentionPolicy.SOURCE)
    @interface Font {}

}
