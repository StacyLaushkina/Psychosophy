package com.laushkina.anastasia.psychosophy.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.RemoteViews;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;

public class Widget extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        String packageName = context.getPackageName();

        RemoteViews typesGridView = new RemoteViews(packageName, R.layout.widget_psychotypes);
        populatePsychotypesViews(context, packageName, typesGridView);

        // Tell the AppWidgetManager to perform an update on this application widget
        // TODO which widget?
        //TODO scroll
        // TODO adjust to the size
        // TODO initial size of the widget
        appWidgetManager.updateAppWidget(appWidgetIds[0], typesGridView);
    }

    private void populatePsychotypesViews(Context context, String packageName, RemoteViews typesGrid) {
        for (Psychotype type : Psychotype.values()) {
            typesGrid.addView(R.id.psychotypes_grid, getElementLayout(context, packageName, type));
        }
    }

    private RemoteViews getElementLayout(Context context, String packageName, Psychotype type) {
        // TODO how to get on which one clicked?
        RemoteViews views = new RemoteViews(packageName, R.layout.widget_psychotype_item);
        views.setTextViewText(R.id.psychotype_title, PsychotypeDescriptionGetter.getTitle(type, context));
        views.setImageViewResource(R.id.psychotype_image, PsychotypeImageGetter.getSrcId(type, context));

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.SCREEN_NAME_EXTRA, Screen.introduction);
        intent.putExtra(PsychotypesFragment.psychotypeExtra, (Parcelable) type);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.widget_psychotype, pendingIntent);

        return views;
    }
}
