package com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;

public class AspectsFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_aspects_and_functions_aspects, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view){
        TextView aspectsWill = view.findViewById(R.id.aspects_info_will);
        aspectsWill.setText(Html.fromHtml(getResources().getString(R.string.aspects_info_will)));

        TextView aspectsLogic = view.findViewById(R.id.aspects_info_logic);
        aspectsLogic.setText(Html.fromHtml(getResources().getString(R.string.aspects_info_logic)));

        TextView aspectsEmotion = view.findViewById(R.id.aspects_info_emotion);
        aspectsEmotion.setText(Html.fromHtml(getResources().getString(R.string.aspects_info_emotion)));

        TextView aspectsPhysics = view.findViewById(R.id.aspects_info_physics);
        aspectsPhysics.setText(Html.fromHtml(getResources().getString(R.string.aspects_info_physics)));
    }
}
