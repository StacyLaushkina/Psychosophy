package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;

final class PsychotypeDescriptionGetter {

    static String getFull(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get full psychotype description");

        switch (psychotype) {
            case LEPW:
                return context.getResources().getString(R.string.LEPW_full);
            case ELWP:
                return context.getResources().getString(R.string.ELWP_full);
            case PLWE:
                return context.getResources().getString(R.string.PLWE_full);
            case WELP:
                return context.getResources().getString(R.string.WELP_full);
            case LPEW:
                return context.getResources().getString(R.string.LPEW_full);
            case PELW:
                return context.getResources().getString(R.string.PELW_full);
            case EPLW:
                return context.getResources().getString(R.string.EPLW_full);
            case EWLP:
                return context.getResources().getString(R.string.EWLP_full);
            case PWLE:
                return context.getResources().getString(R.string.PWLE_full);
            case PEWL:
                return context.getResources().getString(R.string.PEWL_full);
            case WLPE:
                return context.getResources().getString(R.string.WLPE_full);
            case LWPE:
                return context.getResources().getString(R.string.LWPE_full);
            case WPLE:
                return context.getResources().getString(R.string.WPLE_full);
            case LEWP:
                return context.getResources().getString(R.string.LEWP_full);
            case EWPL:
                return context.getResources().getString(R.string.EWPL_full);
            case LPWE:
                return context.getResources().getString(R.string.LPWE_full);
            case EPWL:
                return context.getResources().getString(R.string.EPWL_full);
            case ELPW:
                return context.getResources().getString(R.string.ELPW_full);
            case WLEP:
                return context.getResources().getString(R.string.WLEP_full);
            case WEPL:
                return context.getResources().getString(R.string.WEPL_full);
            case WPEL:
                return context.getResources().getString(R.string.WPEL_full);
            case PWEL:
                return context.getResources().getString(R.string.PWEL_full);
            case LWEP:
                return context.getResources().getString(R.string.LWEP_full);
            case PLEW:
                return context.getResources().getString(R.string.PLEW_full);
            default:
                return "";
        }
    }

    static String getShort(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get full psychotype description");

        switch (psychotype) {
            case LEPW:
                return context.getResources().getString(R.string.LEPW_short);
            case ELWP:
                return context.getResources().getString(R.string.ELWP_short);
            case PLWE:
                return context.getResources().getString(R.string.PLWE_short);
            case WELP:
                return context.getResources().getString(R.string.WELP_short);
            case LPEW:
                return context.getResources().getString(R.string.LPEW_short);
            case PELW:
                return context.getResources().getString(R.string.PELW_short);
            case EPLW:
                return context.getResources().getString(R.string.EPLW_short);
            case EWLP:
                return context.getResources().getString(R.string.EWLP_short);
            case PWLE:
                return context.getResources().getString(R.string.PWLE_short);
            case PEWL:
                return context.getResources().getString(R.string.PEWL_short);
            case WLPE:
                return context.getResources().getString(R.string.WLPE_short);
            case LWPE:
                return context.getResources().getString(R.string.LWPE_short);
            case WPLE:
                return context.getResources().getString(R.string.WPLE_short);
            case LEWP:
                return context.getResources().getString(R.string.LEWP_short);
            case EWPL:
                return context.getResources().getString(R.string.EWPL_short);
            case LPWE:
                return context.getResources().getString(R.string.LPWE_short);
            case EPWL:
                return context.getResources().getString(R.string.EPWL_short);
            case ELPW:
                return context.getResources().getString(R.string.ELPW_short);
            case WLEP:
                return context.getResources().getString(R.string.WLEP_short);
            case WEPL:
                return context.getResources().getString(R.string.WEPL_short);
            case WPEL:
                return context.getResources().getString(R.string.WPEL_short);
            case PWEL:
                return context.getResources().getString(R.string.PWEL_short);
            case LWEP:
                return context.getResources().getString(R.string.LWEP_short);
            case PLEW:
                return context.getResources().getString(R.string.PLEW_short);
            default:
                return "";
        }
    }
}
