package com.laushkina.anastasia.psychosophy.view.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

public class PsychotypesWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new PsychotypesWidgetFactory(getApplicationContext(), Psychotype.values());
    }
}
