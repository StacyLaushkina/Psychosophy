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
        TextView designerAddressLink = view.findViewById(R.id.designer_info_link);
        Linkify.addLinks(designerAddressLink, Linkify.WEB_URLS|Linkify.EMAIL_ADDRESSES);

        TextView afanasievAddressLink = view.findViewById(R.id.afanasiev_info_link);
        Linkify.addLinks(afanasievAddressLink, Linkify.WEB_URLS);

        TextView relationshipsAddressLink = view.findViewById(R.id.relationships_info_link);
        Linkify.addLinks(relationshipsAddressLink, Linkify.WEB_URLS);

        TextView introductionAddressLink = view.findViewById(R.id.introduction_info_link);
        Linkify.addLinks(introductionAddressLink, Linkify.WEB_URLS);
        setTitle();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.about);
    }
}
