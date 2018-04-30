package com.laushkina.anastasia.psychosophy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;

public final class PsychotypeImageGetter {

    public static Drawable get(Psychotype psychotype, Context context) {
        if (psychotype == null || context == null)
            throw new RuntimeException("Cannot get psychotype image");

        int resourceId;
        switch (psychotype) {
            case Augustine:
                resourceId = R.drawable.ic_lepw; break;
            case Anderson:
                resourceId = R.drawable.ic_elwp; break;
            case Aristippus:
                resourceId = R.drawable.ic_plwe; break;
            case Akhmatova:
                resourceId = R.drawable.ic_welp; break;
            case Berthier:
                resourceId = R.drawable.ic_lpew; break;
            case Borgia:
                resourceId = R.drawable.ic_pelw; break;
            case Bukharin:
                resourceId = R.drawable.ic_eplw; break;
            case Ghazali:
                resourceId = R.drawable.ic_ewlp; break;
            case Goethe:
                resourceId = R.drawable.ic_pwle; break;
            case Dumas:
                resourceId = R.drawable.ic_pewl; break;
            case Lenin:
                resourceId = R.drawable.ic_wlpe; break;
            case Lao:
                resourceId = R.drawable.ic_lwpe; break;
            case Napoleon:
                resourceId = R.drawable.ic_wple; break;
            case Pascal:
                resourceId = R.drawable.ic_lewp; break;
            case Parsnip:
                resourceId = R.drawable.ic_ewpl; break;
            case Plato:
                resourceId = R.drawable.ic_lpwe; break;
            case Pushkin:
                resourceId = R.drawable.ic_epwl; break;
            case Rousseau:
                resourceId = R.drawable.ic_elpw; break;
            case Socrates:
                resourceId = R.drawable.ic_wlep; break;
            case Tolstoy:
                resourceId = R.drawable.ic_wepl; break;
            case Twardowski:
                resourceId = R.drawable.ic_wpel; break;
            case Chekhov:
                resourceId = R.drawable.ic_pwel; break;
            case Einstein:
                resourceId = R.drawable.ic_lwep; break;
            case Epicurus:
                resourceId = R.drawable.ic_plew; break;
            default:
                throw new AssertionError("Cannot find image for type" + psychotype.name());
        }

        Bitmap src = BitmapFactory.decodeResource(context.getResources(), resourceId);
        RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(context.getResources(), src);
        dr.setCornerRadius(Math.min(src.getWidth(), src.getHeight()) / 2.0f);
        return dr;
    }
}
