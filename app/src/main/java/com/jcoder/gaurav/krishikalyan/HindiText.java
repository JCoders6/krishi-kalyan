package com.jcoder.gaurav.krishikalyan;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class HindiText extends AppCompatTextView {
    public HindiText(Context context) {
        super(context);
        initTypeface(context);
    }

    public HindiText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface(context);
    }

    public HindiText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeface(context);
    }
    private void initTypeface(Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"NotoSansDevanagari-Regular.ttf");
        this.setTypeface(typeface);
    }
}
