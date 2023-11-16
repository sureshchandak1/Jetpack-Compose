package com.material.sharedcode.widgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.material.sharedcode.R;
import com.material.sharedcode.utils.UIUtils;

public class CustomEditText extends AppCompatEditText {

    public CustomEditText(Context context) {
        super(context);
        init(context, null);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomEditText, 0, 0);
            setFont(typedArray);
            setTextSize();
            addTextChangedListener(textWatcher);
        }
    }

    private void setFont(TypedArray typedArray) {
        try {
            int textFont = typedArray.getInteger(R.styleable.CustomEditText_text_font, 2);
            setTypeface(UIUtils.getFont(getContext(), textFont));
        } finally {
            typedArray.recycle();
        }
    }

    private void setTextSize() {
        final float DEFAULT_TEXT_SIZE = 14;
        setTextSize(DEFAULT_TEXT_SIZE);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String value = editable.toString();
            if (!TextUtils.isEmpty(value)) {
                if (value.contains(",")) {
                    value = value.replace(",", ".");
                    setText(value);
                }
            }
        }
    };
}
