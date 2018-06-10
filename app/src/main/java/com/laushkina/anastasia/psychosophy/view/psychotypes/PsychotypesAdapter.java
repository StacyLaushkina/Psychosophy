package com.laushkina.anastasia.psychosophy.view.psychotypes;

import android.app.FragmentManager;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.NavigationHelper;
import com.laushkina.anastasia.psychosophy.view.PsychotypeImageGetter;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;

public class PsychotypesAdapter extends RecyclerView.Adapter<PsychotypesAdapter.ViewHolder>{

    private Psychotype[] psychotypes;
    private Context context;
    private FragmentManager fragmentManager;

    public PsychotypesAdapter(Psychotype[] psychotypes, Context context, FragmentManager fragmentManager){
        this.psychotypes = psychotypes;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_psychotype_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.typeTitle.setText(PsychotypeDescriptionGetter.getTitle(psychotypes[position], context));
        holder.typeImage.setImageDrawable(PsychotypeImageGetter.get(psychotypes[position], context));
        holder.cardView.setOnClickListener(view -> onClick(position));
    }

    @Override
    public int getItemCount() {
        return psychotypes.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView typeImage;
        private TextView typeTitle;
        private View cardView;

        ViewHolder(View view) {
            super(view);
            this.typeImage = view.findViewById(R.id.psychotype_image);
            this.typeTitle = view.findViewById(R.id.psychotype_title);
            this.cardView = view;
        }
    }

    private void onClick(int position){
        NavigationHelper.getInstance().showTypeDescription(psychotypes[position], fragmentManager);
    }
}
