package com.laushkina.anastasia.psychosophy.view;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;

public final class PsychotypeImageGetter {

    public static Drawable get(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get psychotype image");

        switch (psychotype) {
            case LEPW:
                return context.getResources().getDrawable(R.drawable.ic_lepw);
            case ELWP:
                return context.getResources().getDrawable(R.drawable.ic_elwp);
            case PLWE:
                return context.getResources().getDrawable(R.drawable.ic_plwe);
            case WELP:
                return context.getResources().getDrawable(R.drawable.ic_welp);
            case LPEW:
                return context.getResources().getDrawable(R.drawable.ic_lpew);
            case PELW:
                return context.getResources().getDrawable(R.drawable.ic_pelw);
            case EPLW:
                return context.getResources().getDrawable(R.drawable.ic_eplw);
            case EWLP:
                return context.getResources().getDrawable(R.drawable.ic_ewlp);
            case PWLE:
                return context.getResources().getDrawable(R.drawable.ic_pwle);
            case PEWL:
                return context.getResources().getDrawable(R.drawable.ic_pewl);
            case WLPE:
                return context.getResources().getDrawable(R.drawable.ic_wlpe);
            case LWPE:
                return context.getResources().getDrawable(R.drawable.ic_lwpe);
            case WPLE:
                return context.getResources().getDrawable(R.drawable.ic_wple);
            case LEWP:
                return context.getResources().getDrawable(R.drawable.ic_lewp);
            case EWPL:
                return context.getResources().getDrawable(R.drawable.ic_ewpl);
            case LPWE:
                return context.getResources().getDrawable(R.drawable.ic_lpwe);
            case EPWL:
                return context.getResources().getDrawable(R.drawable.ic_epwl);
            case ELPW:
                return context.getResources().getDrawable(R.drawable.ic_elpw);
            case WLEP:
                return context.getResources().getDrawable(R.drawable.ic_wlep);
            case WEPL:
                return context.getResources().getDrawable(R.drawable.ic_wepl);
            case WPEL:
                return context.getResources().getDrawable(R.drawable.ic_wpel);
            case PWEL:
                return context.getResources().getDrawable(R.drawable.ic_pwel);
            case LWEP:
                return context.getResources().getDrawable(R.drawable.ic_lwep);
            case PLEW:
                return context.getResources().getDrawable(R.drawable.ic_plew);
            default:
                return null;
        }
    }
}
