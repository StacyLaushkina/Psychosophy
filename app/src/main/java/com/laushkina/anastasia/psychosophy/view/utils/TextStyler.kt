package com.laushkina.anastasia.psychosophy.view.utils

import android.content.Context
import android.text.SpannableString
import android.text.style.QuoteSpan
import com.laushkina.anastasia.psychosophy.R

class TextStyler {
    companion object {
        fun style(text: CharSequence, context: Context): CharSequence {
            val spannable = SpannableString(text)
            val quoteSpans = spannable.getSpans(0, spannable.length, QuoteSpan::class.java)
            for (quoteSpan in quoteSpans) {
                val start = spannable.getSpanStart(quoteSpan)
                val end = spannable.getSpanEnd(quoteSpan)
                val flags = spannable.getSpanFlags(quoteSpan)
                spannable.removeSpan(quoteSpan)
                spannable.setSpan(CustomQuoteSpan(context.resources.getColor(R.color.gallery),
                        context.resources.getColor(R.color.colorPrimary),
                        10f, 50f, 8f), start, end, flags)
            }
            return spannable
        }
    }
}