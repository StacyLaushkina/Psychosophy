package com.laushkina.anastasia.psychosophy.view.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.MainActivity;
import com.laushkina.anastasia.psychosophy.view.PsychotypeImageGetter;
import com.laushkina.anastasia.psychosophy.view.Screen;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;

public class PsychotypesWidgetFactory implements RemoteViewsService.RemoteViewsFactory {

    @NonNull
    private Context context;
    @NonNull
    private final Psychotype[] psychotypes;

    PsychotypesWidgetFactory(@NonNull Context context, Psychotype[] psychotypes) {
        this.context = context;
        this.psychotypes = psychotypes;
    }

    @Override
    public void onCreate() { }

    @Override
    public void onDataSetChanged() { }

    @Override
    public void onDestroy() { }

    @Override
    public int getCount() {
        return psychotypes.length;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        Psychotype type = psychotypes[i];

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_psychotype_item);
        views.setTextViewText(R.id.psychotype_title, PsychotypeDescriptionGetter.getTitle(type, context));
        views.setImageViewResource(R.id.psychotype_image, PsychotypeImageGetter.getSrcId(type, context));

        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.SCREEN_NAME_EXTRA, Screen.introduction);
        intent.putExtra(PsychotypesFragment.psychotypeExtra, (Parcelable) type);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 2, intent, 0);
        views.setOnClickPendingIntent(R.id.widget_psychotype, pendingIntent);

        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
