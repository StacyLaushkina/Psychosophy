package com.laushkina.anastasia.psychosophy.view.basesAndFunctions;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;

public class BasesFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_bases_and_functions_bases, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view){
        TextView basesWill = view.findViewById(R.id.bases_info_will);
        basesWill.setText(Html.fromHtml(getResources().getString(R.string.bases_info_will)));

        TextView basesLogic = view.findViewById(R.id.bases_info_logic);
        basesLogic.setText(Html.fromHtml(getResources().getString(R.string.bases_info_logic)));

        TextView basesEmotion = view.findViewById(R.id.bases_info_emotion);
        basesEmotion.setText(Html.fromHtml(getResources().getString(R.string.bases_info_emotion)));

        TextView basesPhysics = view.findViewById(R.id.bases_info_physics);
        basesPhysics.setText(Html.fromHtml(getResources().getString(R.string.bases_info_physics)));
    }
}
