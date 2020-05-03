package com.laushkina.anastasia.psychosophy.view.utils

import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.style.LeadingMarginSpan
import android.text.style.LineBackgroundSpan

/**
 * android.text.style.QuoteSpan hard-codes the strip color and gap.
 */
class CustomQuoteSpan(private val backgroundColor: Int,
                      private val stripeColor: Int,
                      private val stripeWidth: Float,
                      private val gap: Float,
                      private val padding: Float): LeadingMarginSpan, LineBackgroundSpan {

    override fun drawLeadingMargin(canvas: Canvas?, paint: Paint?, x: Int, dir: Int, top: Int, baseline: Int,
                                   bottom: Int, text: CharSequence?, start: Int, end: Int, first: Boolean, layout: Layout?) {
        if (paint == null || canvas == null) {
            return
        }

        val style = paint.style
        val paintColor = paint.color

        paint.style = Paint.Style.FILL
        paint.color = stripeColor

        canvas.drawRect(x.toFloat(), top.toFloat(), x + dir * stripeWidth, bottom.toFloat(), paint)

        paint.style = style
        paint.color = paintColor
    }

    override fun getLeadingMargin(p0: Boolean): Int {
        return (stripeWidth + gap).toInt()
    }

    override fun drawBackground(canvas: Canvas?, paint: Paint?, left: Int, right: Int, top: Int, baseline: Int,
                                bottom: Int, text: CharSequence?, start: Int, end: Int, lnum: Int) {
        if (paint == null || canvas == null) {
            return
        }

        val paintColor = paint.color
        canvas.drawRect(left - padding, top - if (lnum == 0) padding / 2 else -(padding / 2),
                left.toFloat(), (bottom + 8 / 2).toFloat(), paint)
        paint.color = paintColor
    }

}