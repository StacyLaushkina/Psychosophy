package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;

import java.util.ArrayList;
import java.util.List;

public final class PsychotypeDescriptionGetter {

    static String getFull(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get full psychotype description");

        switch (psychotype) {
            case Augustine:
                return context.getResources().getString(R.string.LEPW_full);
            case Anderson:
                return context.getResources().getString(R.string.ELWP_full);
            case Aristippus:
                return context.getResources().getString(R.string.PLWE_full);
            case Akhmatova:
                return context.getResources().getString(R.string.WELP_full);
            case Berthier:
                return context.getResources().getString(R.string.LPEW_full);
            case Borgia:
                return context.getResources().getString(R.string.PELW_full);
            case Bukharin:
                return context.getResources().getString(R.string.EPLW_full);
            case Ghazali:
                return context.getResources().getString(R.string.EWLP_full);
            case Goethe:
                return context.getResources().getString(R.string.PWLE_full);
            case Dumas:
                return context.getResources().getString(R.string.PEWL_full);
            case Lenin:
                return context.getResources().getString(R.string.WLPE_full);
            case Lao:
                return context.getResources().getString(R.string.LWPE_full);
            case Napoleon:
                return context.getResources().getString(R.string.WPLE_full);
            case Pascal:
                return context.getResources().getString(R.string.LEWP_full);
            case Parsnip:
                return context.getResources().getString(R.string.EWPL_full);
            case Plato:
                return context.getResources().getString(R.string.LPWE_full);
            case Pushkin:
                return context.getResources().getString(R.string.EPWL_full);
            case Rousseau:
                return context.getResources().getString(R.string.ELPW_full);
            case Socrates:
                return context.getResources().getString(R.string.WLEP_full);
            case Tolstoy:
                return context.getResources().getString(R.string.WEPL_full);
            case Twardowski:
                return context.getResources().getString(R.string.WPEL_full);
            case Chekhov:
                return context.getResources().getString(R.string.PWEL_full);
            case Einstein:
                return context.getResources().getString(R.string.LWEP_full);
            case Epicurus:
                return context.getResources().getString(R.string.PLEW_full);
            default:
                throw new AssertionError();
        }
    }

    public static String getTitle(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get psychotype title");

        switch (psychotype) {
            case Augustine:
                return context.getResources().getString(R.string.LEPW_title);
            case Anderson:
                return context.getResources().getString(R.string.ELWP_title);
            case Aristippus:
                return context.getResources().getString(R.string.PLWE_title);
            case Akhmatova:
                return context.getResources().getString(R.string.WELP_title);
            case Berthier:
                return context.getResources().getString(R.string.LPEW_title);
            case Borgia:
                return context.getResources().getString(R.string.PELW_title);
            case Bukharin:
                return context.getResources().getString(R.string.EPLW_title);
            case Ghazali:
                return context.getResources().getString(R.string.EWLP_title);
            case Goethe:
                return context.getResources().getString(R.string.PWLE_title);
            case Dumas:
                return context.getResources().getString(R.string.PEWL_title);
            case Lenin:
                return context.getResources().getString(R.string.WLPE_title);
            case Lao:
                return context.getResources().getString(R.string.LWPE_title);
            case Napoleon:
                return context.getResources().getString(R.string.WPLE_title);
            case Pascal:
                return context.getResources().getString(R.string.LEWP_title);
            case Parsnip:
                return context.getResources().getString(R.string.EWPL_title);
            case Plato:
                return context.getResources().getString(R.string.LPWE_title);
            case Pushkin:
                return context.getResources().getString(R.string.EPWL_title);
            case Rousseau:
                return context.getResources().getString(R.string.ELPW_title);
            case Socrates:
                return context.getResources().getString(R.string.WLEP_title);
            case Tolstoy:
                return context.getResources().getString(R.string.WEPL_title);
            case Twardowski:
                return context.getResources().getString(R.string.WPEL_title);
            case Chekhov:
                return context.getResources().getString(R.string.PWEL_title);
            case Einstein:
                return context.getResources().getString(R.string.LWEP_title);
            case Epicurus:
                return context.getResources().getString(R.string.PLEW_title);
            default:
                throw new AssertionError();
        }
    }

    public static List<String> getAllDescriptions(Context context){
        return new ArrayList<String>() {{
            add(context.getResources().getString(R.string.LEPW_title));
            add(context.getResources().getString(R.string.ELWP_title));
            add(context.getResources().getString(R.string.PLWE_title));
            add(context.getResources().getString(R.string.WELP_title));
            add(context.getResources().getString(R.string.LPEW_title));
            add(context.getResources().getString(R.string.PELW_title));
            add(context.getResources().getString(R.string.EPLW_title));
            add(context.getResources().getString(R.string.EWLP_title));
            add(context.getResources().getString(R.string.PWLE_title));
            add(context.getResources().getString(R.string.PEWL_title));
            add(context.getResources().getString(R.string.WLPE_title));
            add(context.getResources().getString(R.string.LWPE_title));
            add(context.getResources().getString(R.string.WPLE_title));
            add(context.getResources().getString(R.string.LEWP_title));
            add(context.getResources().getString(R.string.EWPL_title));
            add(context.getResources().getString(R.string.LPWE_title));
            add(context.getResources().getString(R.string.EPWL_title));
            add(context.getResources().getString(R.string.ELPW_title));
            add(context.getResources().getString(R.string.WLEP_title));
            add(context.getResources().getString(R.string.WEPL_title));
            add(context.getResources().getString(R.string.WPEL_title));
            add(context.getResources().getString(R.string.PWEL_title));
            add(context.getResources().getString(R.string.LWEP_title));
            add(context.getResources().getString(R.string.PLEW_title));
        }};
    }

    static String getShort(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get short psychotype description");

        switch (psychotype) {
            case Augustine:
                return context.getResources().getString(R.string.LEPW_short);
            case Anderson:
                return context.getResources().getString(R.string.ELWP_short);
            case Aristippus:
                return context.getResources().getString(R.string.PLWE_short);
            case Akhmatova:
                return context.getResources().getString(R.string.WELP_short);
            case Berthier:
                return context.getResources().getString(R.string.LPEW_short);
            case Borgia:
                return context.getResources().getString(R.string.PELW_short);
            case Bukharin:
                return context.getResources().getString(R.string.EPLW_short);
            case Ghazali:
                return context.getResources().getString(R.string.EWLP_short);
            case Goethe:
                return context.getResources().getString(R.string.PWLE_short);
            case Dumas:
                return context.getResources().getString(R.string.PEWL_short);
            case Lenin:
                return context.getResources().getString(R.string.WLPE_short);
            case Lao:
                return context.getResources().getString(R.string.LWPE_short);
            case Napoleon:
                return context.getResources().getString(R.string.WPLE_short);
            case Pascal:
                return context.getResources().getString(R.string.LEWP_short);
            case Parsnip:
                return context.getResources().getString(R.string.EWPL_short);
            case Plato:
                return context.getResources().getString(R.string.LPWE_short);
            case Pushkin:
                return context.getResources().getString(R.string.EPWL_short);
            case Rousseau:
                return context.getResources().getString(R.string.ELPW_short);
            case Socrates:
                return context.getResources().getString(R.string.WLEP_short);
            case Tolstoy:
                return context.getResources().getString(R.string.WEPL_short);
            case Twardowski:
                return context.getResources().getString(R.string.WPEL_short);
            case Chekhov:
                return context.getResources().getString(R.string.PWEL_short);
            case Einstein:
                return context.getResources().getString(R.string.LWEP_short);
            case Epicurus:
                return context.getResources().getString(R.string.PLEW_short);
            default:
                throw new AssertionError();
        }
    }
}
