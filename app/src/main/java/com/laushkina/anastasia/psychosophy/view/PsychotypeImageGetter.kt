package com.laushkina.anastasia.psychosophy.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype

class PsychotypeImageGetter {
    companion object {
        operator fun get(psychotype: Psychotype?, context: Context?): Drawable {
            if (psychotype == null || context == null)
                throw RuntimeException("Cannot get psychotype image")

            val resourceId: Int
            when (psychotype) {
                Psychotype.Augustine -> resourceId = R.drawable.ic_lepw
                Psychotype.Anderson -> resourceId = R.drawable.ic_elwp
                Psychotype.Aristippus -> resourceId = R.drawable.ic_plwe
                Psychotype.Akhmatova -> resourceId = R.drawable.ic_welp
                Psychotype.Berthier -> resourceId = R.drawable.ic_lpew
                Psychotype.Borgia -> resourceId = R.drawable.ic_pelw
                Psychotype.Bukharin -> resourceId = R.drawable.ic_eplw
                Psychotype.Ghazali -> resourceId = R.drawable.ic_ewlp
                Psychotype.Goethe -> resourceId = R.drawable.ic_pwle
                Psychotype.Dumas -> resourceId = R.drawable.ic_pewl
                Psychotype.Lenin -> resourceId = R.drawable.ic_wlpe
                Psychotype.Lao -> resourceId = R.drawable.ic_lwpe
                Psychotype.Napoleon -> resourceId = R.drawable.ic_wple
                Psychotype.Pascal -> resourceId = R.drawable.ic_lewp
                Psychotype.Parsnip -> resourceId = R.drawable.ic_ewpl
                Psychotype.Plato -> resourceId = R.drawable.ic_lpwe
                Psychotype.Pushkin -> resourceId = R.drawable.ic_epwl
                Psychotype.Rousseau -> resourceId = R.drawable.ic_elpw
                Psychotype.Socrates -> resourceId = R.drawable.ic_wlep
                Psychotype.Tolstoy -> resourceId = R.drawable.ic_wepl
                Psychotype.Twardowski -> resourceId = R.drawable.ic_wpel
                Psychotype.Chekhov -> resourceId = R.drawable.ic_pwel
                Psychotype.Einstein -> resourceId = R.drawable.ic_lwep
                Psychotype.Epicurus -> resourceId = R.drawable.ic_plew
            }

            val src = BitmapFactory.decodeResource(context.resources, resourceId)
            val dr = RoundedBitmapDrawableFactory.create(context.resources, src)
            dr.cornerRadius = src.width.coerceAtMost(src.height) / 2.0f
            return dr
        }
    }
}