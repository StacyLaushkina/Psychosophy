package com.laushkina.anastasia.psychosophy.view.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

public class ImageWrapper implements LeadingMarginSpan.LeadingMarginSpan2 {
    private int margin;
    private int lines;

    public ImageWrapper(int imageHeight, int lineHeight, int imageWidth) {
        this(imageHeight/lineHeight, imageWidth);
    }

    private ImageWrapper(int lines, int margin) {
        this.margin = margin;
        this.lines = lines;
    }

    // Will be applied to lines which are returned by getLeadingMarginLineCount()
    @Override
    public int getLeadingMargin(boolean first) {
        return first ? margin : 0;
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
                                  int top, int baseline, int bottom, CharSequence text,
                                  int start, int end, boolean first, Layout layout) {}

    @Override
    public int getLeadingMarginLineCount() {
        return lines;
    }
}