package com.laushkina.anastasia.psychosophy.view.psychotypeDescription

import android.content.Context
import android.text.Html
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.utils.TextStyler

class PsychotypeDescriptionGetter {
    companion object {
        fun getFull(psychotype: Psychotype?, context: Context?): CharSequence {
            if (psychotype == null || context == null)
                throw RuntimeException("Cannot get full psychotype description")

            val rawText: String
            when (psychotype) {
                Psychotype.Augustine -> rawText = context.resources.getString(R.string.LEPW_full)
                Psychotype.Anderson -> rawText = context.resources.getString(R.string.ELWP_full)
                Psychotype.Aristippus -> rawText = context.resources.getString(R.string.PLWE_full)
                Psychotype.Akhmatova -> rawText = context.resources.getString(R.string.WELP_full)
                Psychotype.Berthier -> rawText = context.resources.getString(R.string.LPEW_full)
                Psychotype.Borgia -> rawText = context.resources.getString(R.string.PELW_full)
                Psychotype.Bukharin -> rawText = context.resources.getString(R.string.EPLW_full)
                Psychotype.Ghazali -> rawText = context.resources.getString(R.string.EWLP_full)
                Psychotype.Goethe -> rawText = context.resources.getString(R.string.PWLE_full)
                Psychotype.Dumas -> rawText = context.resources.getString(R.string.PEWL_full)
                Psychotype.Lenin -> rawText = context.resources.getString(R.string.WLPE_full)
                Psychotype.Lao -> rawText = context.resources.getString(R.string.LWPE_full)
                Psychotype.Napoleon -> rawText = context.resources.getString(R.string.WPLE_full)
                Psychotype.Pascal -> rawText = context.resources.getString(R.string.LEWP_full)
                Psychotype.Parsnip -> rawText = context.resources.getString(R.string.EWPL_full)
                Psychotype.Plato -> rawText = context.resources.getString(R.string.LPWE_full)
                Psychotype.Pushkin -> rawText = context.resources.getString(R.string.EPWL_full)
                Psychotype.Rousseau -> rawText = context.resources.getString(R.string.ELPW_full)
                Psychotype.Socrates -> rawText = context.resources.getString(R.string.WLEP_full)
                Psychotype.Tolstoy -> rawText = context.resources.getString(R.string.WEPL_full)
                Psychotype.Twardowski -> rawText = context.resources.getString(R.string.WPEL_full)
                Psychotype.Chekhov -> rawText = context.resources.getString(R.string.PWEL_full)
                Psychotype.Einstein -> rawText = context.resources.getString(R.string.LWEP_full)
                Psychotype.Epicurus -> rawText = context.resources.getString(R.string.PLEW_full)
            }

            return TextStyler.style(Html.fromHtml(rawText), context)
        }

        fun getTitle(psychotype: Psychotype?, context: Context?): CharSequence {
            if (psychotype == null || context == null)
                throw RuntimeException("Cannot get psychotype title")

            val rawText: String
            when (psychotype) {
                Psychotype.Augustine -> rawText = context.resources.getString(R.string.LEPW_title)
                Psychotype.Anderson -> rawText = context.resources.getString(R.string.ELWP_title)
                Psychotype.Aristippus -> rawText = context.resources.getString(R.string.PLWE_title)
                Psychotype.Akhmatova -> rawText = context.resources.getString(R.string.WELP_title)
                Psychotype.Berthier -> rawText = context.resources.getString(R.string.LPEW_title)
                Psychotype.Borgia -> rawText = context.resources.getString(R.string.PELW_title)
                Psychotype.Bukharin -> rawText = context.resources.getString(R.string.EPLW_title)
                Psychotype.Ghazali -> rawText = context.resources.getString(R.string.EWLP_title)
                Psychotype.Goethe -> rawText = context.resources.getString(R.string.PWLE_title)
                Psychotype.Dumas -> rawText = context.resources.getString(R.string.PEWL_title)
                Psychotype.Lenin -> rawText = context.resources.getString(R.string.WLPE_title)
                Psychotype.Lao -> rawText = context.resources.getString(R.string.LWPE_title)
                Psychotype.Napoleon -> rawText = context.resources.getString(R.string.WPLE_title)
                Psychotype.Pascal -> rawText = context.resources.getString(R.string.LEWP_title)
                Psychotype.Parsnip -> rawText = context.resources.getString(R.string.EWPL_title)
                Psychotype.Plato -> rawText = context.resources.getString(R.string.LPWE_title)
                Psychotype.Pushkin -> rawText = context.resources.getString(R.string.EPWL_title)
                Psychotype.Rousseau -> rawText = context.resources.getString(R.string.ELPW_title)
                Psychotype.Socrates -> rawText = context.resources.getString(R.string.WLEP_title)
                Psychotype.Tolstoy -> rawText = context.resources.getString(R.string.WEPL_title)
                Psychotype.Twardowski -> rawText = context.resources.getString(R.string.WPEL_title)
                Psychotype.Chekhov -> rawText = context.resources.getString(R.string.PWEL_title)
                Psychotype.Einstein -> rawText = context.resources.getString(R.string.LWEP_title)
                Psychotype.Epicurus -> rawText = context.resources.getString(R.string.PLEW_title)
            }

            return rawText
        }

        fun getShort(psychotype: Psychotype?, context: Context?): CharSequence {
            if (psychotype == null || context == null)
                throw RuntimeException("Cannot get short psychotype description")

            val rawText: String
            when (psychotype) {
                Psychotype.Augustine -> rawText = context.resources.getString(R.string.LEPW_short)
                Psychotype.Anderson -> rawText = context.resources.getString(R.string.ELWP_short)
                Psychotype.Aristippus -> rawText = context.resources.getString(R.string.PLWE_short)
                Psychotype.Akhmatova -> rawText = context.resources.getString(R.string.WELP_short)
                Psychotype.Berthier -> rawText = context.resources.getString(R.string.LPEW_short)
                Psychotype.Borgia -> rawText = context.resources.getString(R.string.PELW_short)
                Psychotype.Bukharin -> rawText = context.resources.getString(R.string.EPLW_short)
                Psychotype.Ghazali -> rawText = context.resources.getString(R.string.EWLP_short)
                Psychotype.Goethe -> rawText = context.resources.getString(R.string.PWLE_short)
                Psychotype.Dumas -> rawText = context.resources.getString(R.string.PEWL_short)
                Psychotype.Lenin -> rawText = context.resources.getString(R.string.WLPE_short)
                Psychotype.Lao -> rawText = context.resources.getString(R.string.LWPE_short)
                Psychotype.Napoleon -> rawText = context.resources.getString(R.string.WPLE_short)
                Psychotype.Pascal -> rawText = context.resources.getString(R.string.LEWP_short)
                Psychotype.Parsnip -> rawText = context.resources.getString(R.string.EWPL_short)
                Psychotype.Plato -> rawText = context.resources.getString(R.string.LPWE_short)
                Psychotype.Pushkin -> rawText = context.resources.getString(R.string.EPWL_short)
                Psychotype.Rousseau -> rawText = context.resources.getString(R.string.ELPW_short)
                Psychotype.Socrates -> rawText = context.resources.getString(R.string.WLEP_short)
                Psychotype.Tolstoy -> rawText = context.resources.getString(R.string.WEPL_short)
                Psychotype.Twardowski -> rawText = context.resources.getString(R.string.WPEL_short)
                Psychotype.Chekhov -> rawText = context.resources.getString(R.string.PWEL_short)
                Psychotype.Einstein -> rawText = context.resources.getString(R.string.LWEP_short)
                Psychotype.Epicurus -> rawText = context.resources.getString(R.string.PLEW_short)
            }

            return TextStyler.style(Html.fromHtml(rawText), context)
        }
    }
}