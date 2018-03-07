package com.laushkina.anastasia.psychosophy.view.psychotypes;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesPsychotypeItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesPsychotypeItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
    }
}
