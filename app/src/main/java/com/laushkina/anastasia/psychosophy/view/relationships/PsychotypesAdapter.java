package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;

public class PsychotypesAdapter extends ArrayAdapter<Psychotype> {

    private int resourceLayout;

    public PsychotypesAdapter(@NonNull Context context, int resource, Psychotype[] psychotypes) {
        super(context, resource, psychotypes);
        this.resourceLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Psychotype psychotype = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceLayout, null);
        }
        // First item must e empty
        ((TextView) convertView.findViewById(android.R.id.text1))
                .setText(psychotype == null ? null : PsychotypeDescriptionGetter.getTitle(psychotype, getContext()));
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceLayout, null);
        }
        Psychotype psychotype = getItem(position);

        // First item must e empty
        ((TextView) convertView.findViewById(android.R.id.text1))
                .setText(psychotype == null ? null : PsychotypeDescriptionGetter.getTitle(psychotype, getContext()));
        return convertView;
    }

}
