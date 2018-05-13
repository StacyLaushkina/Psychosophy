package com.laushkina.anastasia.psychosophy.view.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.QuoteSpan;

import com.laushkina.anastasia.psychosophy.R;

public class TextStylezer {

    public static CharSequence style(CharSequence text, Context context) {
        SpannableString spannable = new SpannableString(text);
        QuoteSpan[] quoteSpans = spannable.getSpans(0, spannable.length(), QuoteSpan.class);
        for (QuoteSpan quoteSpan : quoteSpans) {
            int start = spannable.getSpanStart(quoteSpan);
            int end = spannable.getSpanEnd(quoteSpan);
            int flags = spannable.getSpanFlags(quoteSpan);
            spannable.removeSpan(quoteSpan);
            spannable.setSpan(new CustomQuoteSpan(
                            context.getResources().getColor(R.color.gallery),
                    context.getResources().getColor(R.color.colorPrimary),
                            10,
                            50),
                    start,
                    end,
                    flags);
        }
        return spannable;
    }
}
