package com.laushkina.anastasia.psychosophy.view.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.view.test.TestViewModel;

public class ViewHideAnimation {
    public static void crossfade(TextView view, TestViewModel viewModel, String text) {

        view.animate()
                .alpha(0f)
                .setDuration(100)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                       // viewModel.setQuestion(text);
                        view.animate()
                                .alpha(1f)
                                .setDuration(500)
                                .setListener(null);

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });



    }
}
