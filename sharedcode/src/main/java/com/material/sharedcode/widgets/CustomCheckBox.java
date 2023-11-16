package com.material.sharedcode.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.material.sharedcode.R;
import com.material.sharedcode.utils.UIUtils;

public class CustomCheckBox extends AppCompatCheckBox {

    public CustomCheckBox(Context context) {
        super(context);
        init(context, null);
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomCheckBox, 0, 0);
            if (typedArray != null) {
                setFont(typedArray);
            }
        }
    }

    private void setFont(TypedArray typedArray) {
        try {
            int textFont = typedArray.getInteger(R.styleable.CustomCheckBox_text_font, 0);
            setTypeface(UIUtils.getFont(getContext(), textFont));
        } finally {
            typedArray.recycle();
        }
    }
}
