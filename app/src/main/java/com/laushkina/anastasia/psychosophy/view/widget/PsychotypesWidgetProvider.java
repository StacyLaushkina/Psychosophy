package com.laushkina.anastasia.psychosophy.view.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.laushkina.anastasia.psychosophy.R;

public class PsychotypesWidgetProvider extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            //TODO scroll
//        // TODO adjust to the size
//        // TODO initial size of the widget
            Intent adapter = new Intent(context, PsychotypesWidgetService.class);
            adapter.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_psychotypes);
            views.setRemoteAdapter(R.id.psychotypes_grid, adapter);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
