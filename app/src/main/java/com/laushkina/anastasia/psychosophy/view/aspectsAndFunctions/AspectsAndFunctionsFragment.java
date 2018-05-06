package com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class AspectsAndFunctionsFragment extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_aspects_and_functions, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view){
        setTitle();
        TextView aspects = view.findViewById(R.id.aspects_info_view);
        aspects.setText(Html.fromHtml(getResources().getString(R.string.aspects_info)));

        TextView functions = view.findViewById(R.id.functions_info_view);
        functions.setText(Html.fromHtml(getResources().getString(R.string.functions_info)));
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.aspects_and_functions);
    }
}
