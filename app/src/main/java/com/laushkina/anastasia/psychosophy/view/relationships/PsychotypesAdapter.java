package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;
import android.graphics.Color;
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
    private int firstItemColor;
    private String promtTest;

    PsychotypesAdapter(@NonNull Context context, int resource, Psychotype[] psychotypes, String promtTest, int firstItemColor) {
        super(context, resource, psychotypes);
        this.resourceLayout = resource;
        this.promtTest = promtTest;
        this.firstItemColor = firstItemColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceLayout, null);
        }

        initText(convertView, position);
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceLayout, null);
        }

        initText(convertView, position);
        return convertView;
    }

    private void initText(View convertView, int position){
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(getText(position));
        if (position == 0) {
            textView.setTextColor(firstItemColor);
        } else  {
            textView.setTextColor(Color.BLACK);
        }
    }

    private CharSequence getText(int position){
        Psychotype psychotype = getItem(position);
        //First item is prompt
        return position == 0 ? promtTest : PsychotypeDescriptionGetter.getTitle(psychotype, getContext());
    }

}
