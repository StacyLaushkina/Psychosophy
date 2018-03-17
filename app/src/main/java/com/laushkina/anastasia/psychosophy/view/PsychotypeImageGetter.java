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
            case Augustine:
                return context.getResources().getDrawable(R.drawable.ic_lepw);
            case Anderson:
                return context.getResources().getDrawable(R.drawable.ic_elwp);
            case Aristippus:
                return context.getResources().getDrawable(R.drawable.ic_plwe);
            case Akhmatova:
                return context.getResources().getDrawable(R.drawable.ic_welp);
            case Berthier:
                return context.getResources().getDrawable(R.drawable.ic_lpew);
            case Borgia:
                return context.getResources().getDrawable(R.drawable.ic_pelw);
            case Bukharin:
                return context.getResources().getDrawable(R.drawable.ic_eplw);
            case Ghazali:
                return context.getResources().getDrawable(R.drawable.ic_ewlp);
            case Goethe:
                return context.getResources().getDrawable(R.drawable.ic_pwle);
            case Dumas:
                return context.getResources().getDrawable(R.drawable.ic_pewl);
            case Lenin:
                return context.getResources().getDrawable(R.drawable.ic_wlpe);
            case Lao:
                return context.getResources().getDrawable(R.drawable.ic_lwpe);
            case Napoleon:
                return context.getResources().getDrawable(R.drawable.ic_wple);
            case Pascal:
                return context.getResources().getDrawable(R.drawable.ic_lewp);
            case Parsnip:
                return context.getResources().getDrawable(R.drawable.ic_ewpl);
            case Plato:
                return context.getResources().getDrawable(R.drawable.ic_lpwe);
            case Pushkin:
                return context.getResources().getDrawable(R.drawable.ic_epwl);
            case Rousseau:
                return context.getResources().getDrawable(R.drawable.ic_elpw);
            case Socrates:
                return context.getResources().getDrawable(R.drawable.ic_wlep);
            case Tolstoy:
                return context.getResources().getDrawable(R.drawable.ic_wepl);
            case Twardowski:
                return context.getResources().getDrawable(R.drawable.ic_wpel);
            case Chekhov:
                return context.getResources().getDrawable(R.drawable.ic_pwel);
            case Einstein:
                return context.getResources().getDrawable(R.drawable.ic_lwep);
            case Epicurus:
                return context.getResources().getDrawable(R.drawable.ic_plew);
            default:
                return null;
        }
    }
}
