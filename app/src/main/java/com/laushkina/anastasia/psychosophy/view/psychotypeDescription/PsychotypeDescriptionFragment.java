package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;

public class PsychotypeDescriptionFragment extends BaseFragment {
    private ViewPager descriptionViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_psychotype_description, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view) {
        descriptionViewPager = getDescriptionsViewPager(view);
        descriptionViewPager.setAdapter(new PsychotypeDescriptionAdapter(getChildFragmentManager(), getPsychotype()));

        getSwitchButton(view).setOnClickListener(v -> switchPage());
    }

    private void switchPage(){
        int current = descriptionViewPager.getCurrentItem();
        switch (current) {
            case PsychotypeDescriptionAdapter.PREVIEW_DESCRIPTION: {
                getSwitchButton().setText("Less");
                descriptionViewPager.setCurrentItem(PsychotypeDescriptionAdapter.FULL_TEXT_DESCRIPTION);
                break;
            }
            case PsychotypeDescriptionAdapter.FULL_TEXT_DESCRIPTION:{
                getSwitchButton().setText("More");
                descriptionViewPager.setCurrentItem(PsychotypeDescriptionAdapter.PREVIEW_DESCRIPTION);
                break;
            }
        }
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.psychotype_description);
    }

    private ViewPager getDescriptionsViewPager(View view){
        return view.findViewById(R.id.description_pager);
    }

    private ViewPager getDescriptionsViewPager(){
        return getActivity().findViewById(R.id.description_pager);
    }

    private Psychotype getPsychotype(){
        return (Psychotype)getArguments().getSerializable(PsychotypesFragment.psychotypeExtra);
    }

    private Button getSwitchButton(){
        return getActivity().findViewById(R.id.switch_button);
    }

    private Button getSwitchButton(View view) {
        return view.findViewById(R.id.switch_button);
    }

}
