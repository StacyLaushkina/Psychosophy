package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.content.Context;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.utils.TextStylezer;

import java.util.ArrayList;
import java.util.List;

public final class PsychotypeDescriptionGetter {

    static CharSequence getFull(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get full psychotype description");

        String rawText;
        switch (psychotype) {
            case Augustine:
                rawText = context.getResources().getString(R.string.LEPW_full); break;
            case Anderson:
                rawText = context.getResources().getString(R.string.ELWP_full); break;
            case Aristippus:
                rawText = context.getResources().getString(R.string.PLWE_full); break;
            case Akhmatova:
                rawText = context.getResources().getString(R.string.WELP_full); break;
            case Berthier:
                rawText = context.getResources().getString(R.string.LPEW_full); break;
            case Borgia:
                rawText = context.getResources().getString(R.string.PELW_full); break;
            case Bukharin:
                rawText = context.getResources().getString(R.string.EPLW_full); break;
            case Ghazali:
                rawText = context.getResources().getString(R.string.EWLP_full); break;
            case Goethe:
                rawText = context.getResources().getString(R.string.PWLE_full); break;
            case Dumas:
                rawText = context.getResources().getString(R.string.PEWL_full); break;
            case Lenin:
                rawText = context.getResources().getString(R.string.WLPE_full); break;
            case Lao:
                rawText = context.getResources().getString(R.string.LWPE_full); break;
            case Napoleon:
                rawText = context.getResources().getString(R.string.WPLE_full); break;
            case Pascal:
                rawText = context.getResources().getString(R.string.LEWP_full); break;
            case Parsnip:
                rawText = context.getResources().getString(R.string.EWPL_full); break;
            case Plato:
                rawText = context.getResources().getString(R.string.LPWE_full); break;
            case Pushkin:
                rawText = context.getResources().getString(R.string.EPWL_full); break;
            case Rousseau:
                rawText = context.getResources().getString(R.string.ELPW_full); break;
            case Socrates:
                rawText = context.getResources().getString(R.string.WLEP_full); break;
            case Tolstoy:
                rawText = context.getResources().getString(R.string.WEPL_full); break;
            case Twardowski:
                rawText = context.getResources().getString(R.string.WPEL_full); break;
            case Chekhov:
                rawText = context.getResources().getString(R.string.PWEL_full); break;
            case Einstein:
                rawText = context.getResources().getString(R.string.LWEP_full); break;
            case Epicurus:
                rawText = context.getResources().getString(R.string.PLEW_full); break;
            default:
                throw new AssertionError();
        }

        return TextStylezer.style(Html.fromHtml(rawText), context);
    }

    public static CharSequence getTitle(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get psychotype title");

        String rawText;
        switch (psychotype) {
            case Augustine:
                rawText = context.getResources().getString(R.string.LEPW_title); break;
            case Anderson:
                rawText = context.getResources().getString(R.string.ELWP_title); break;
            case Aristippus:
                rawText = context.getResources().getString(R.string.PLWE_title); break;
            case Akhmatova:
                rawText = context.getResources().getString(R.string.WELP_title); break;
            case Berthier:
                rawText = context.getResources().getString(R.string.LPEW_title); break;
            case Borgia:
                rawText = context.getResources().getString(R.string.PELW_title); break;
            case Bukharin:
                rawText = context.getResources().getString(R.string.EPLW_title); break;
            case Ghazali:
                rawText = context.getResources().getString(R.string.EWLP_title); break;
            case Goethe:
                rawText = context.getResources().getString(R.string.PWLE_title); break;
            case Dumas:
                rawText = context.getResources().getString(R.string.PEWL_title); break;
            case Lenin:
                rawText = context.getResources().getString(R.string.WLPE_title); break;
            case Lao:
                rawText = context.getResources().getString(R.string.LWPE_title); break;
            case Napoleon:
                rawText = context.getResources().getString(R.string.WPLE_title); break;
            case Pascal:
                rawText = context.getResources().getString(R.string.LEWP_title); break;
            case Parsnip:
                rawText = context.getResources().getString(R.string.EWPL_title); break;
            case Plato:
                rawText = context.getResources().getString(R.string.LPWE_title); break;
            case Pushkin:
                rawText = context.getResources().getString(R.string.EPWL_title); break;
            case Rousseau:
                rawText = context.getResources().getString(R.string.ELPW_title); break;
            case Socrates:
                rawText = context.getResources().getString(R.string.WLEP_title); break;
            case Tolstoy:
                rawText = context.getResources().getString(R.string.WEPL_title); break;
            case Twardowski:
                rawText = context.getResources().getString(R.string.WPEL_title); break;
            case Chekhov:
                rawText = context.getResources().getString(R.string.PWEL_title); break;
            case Einstein:
                rawText = context.getResources().getString(R.string.LWEP_title); break;
            case Epicurus:
                rawText = context.getResources().getString(R.string.PLEW_title); break;
            default:
                throw new AssertionError();
        }

        return rawText;
    }

    static CharSequence getShort(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get short psychotype description");

        String rawText;
        switch (psychotype) {
            case Augustine:
                rawText = context.getResources().getString(R.string.LEPW_short); break;
            case Anderson:
                rawText = context.getResources().getString(R.string.ELWP_short); break;
            case Aristippus:
                rawText = context.getResources().getString(R.string.PLWE_short); break;
            case Akhmatova:
                rawText = context.getResources().getString(R.string.WELP_short); break;
            case Berthier:
                rawText = context.getResources().getString(R.string.LPEW_short); break;
            case Borgia:
                rawText = context.getResources().getString(R.string.PELW_short); break;
            case Bukharin:
                rawText = context.getResources().getString(R.string.EPLW_short); break;
            case Ghazali:
                rawText = context.getResources().getString(R.string.EWLP_short); break;
            case Goethe:
                rawText = context.getResources().getString(R.string.PWLE_short); break;
            case Dumas:
                rawText = context.getResources().getString(R.string.PEWL_short); break;
            case Lenin:
                rawText = context.getResources().getString(R.string.WLPE_short); break;
            case Lao:
                rawText = context.getResources().getString(R.string.LWPE_short); break;
            case Napoleon:
                rawText = context.getResources().getString(R.string.WPLE_short); break;
            case Pascal:
                rawText = context.getResources().getString(R.string.LEWP_short); break;
            case Parsnip:
                rawText = context.getResources().getString(R.string.EWPL_short); break;
            case Plato:
                rawText = context.getResources().getString(R.string.LPWE_short); break;
            case Pushkin:
                rawText = context.getResources().getString(R.string.EPWL_short); break;
            case Rousseau:
                rawText = context.getResources().getString(R.string.ELPW_short); break;
            case Socrates:
                rawText = context.getResources().getString(R.string.WLEP_short); break;
            case Tolstoy:
                rawText = context.getResources().getString(R.string.WEPL_short); break;
            case Twardowski:
                rawText = context.getResources().getString(R.string.WPEL_short); break;
            case Chekhov:
                rawText = context.getResources().getString(R.string.PWEL_short); break;
            case Einstein:
                rawText = context.getResources().getString(R.string.LWEP_short); break;
            case Epicurus:
                rawText = context.getResources().getString(R.string.PLEW_short); break;
            default:
                throw new AssertionError();
        }

        return TextStylezer.style(Html.fromHtml(rawText), context);
    }
}
