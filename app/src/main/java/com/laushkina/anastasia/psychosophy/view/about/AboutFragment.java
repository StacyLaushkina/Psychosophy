package com.laushkina.anastasia.psychosophy.view.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class AboutFragment extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view){
        TextView developerAdressLink = view.findViewById(R.id.developer_info_link);
        Linkify.addLinks(developerAdressLink, Linkify.WEB_URLS|Linkify.EMAIL_ADDRESSES);

        TextView afanasievAdressLink = view.findViewById(R.id.afanasiev_info_link);
        Linkify.addLinks(afanasievAdressLink, Linkify.WEB_URLS);

        TextView relationshipsAdressLink = view.findViewById(R.id.relationships_info_link);
        Linkify.addLinks(relationshipsAdressLink, Linkify.WEB_URLS);

        TextView introductionAdressLink = view.findViewById(R.id.introduction_info_link);
        Linkify.addLinks(introductionAdressLink, Linkify.WEB_URLS);
        setTitle();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.about);
    }
}
