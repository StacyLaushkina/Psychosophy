package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;

public interface IRelationshipsResultObserver {
    void hideHint();
    void showHint();
    Context getContext();
}
