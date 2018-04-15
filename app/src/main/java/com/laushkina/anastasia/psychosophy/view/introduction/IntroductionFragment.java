package com.laushkina.anastasia.psychosophy.view.introduction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class IntroductionFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_introduction, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view){
        TextView introductionText = view.findViewById(R.id.introduction_text);
        introductionText.setText(Html.fromHtml(getResources().getString(R.string.introduction_text)));
        setTitle();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.introduction);
    }
}
