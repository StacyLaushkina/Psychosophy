package com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class AspectAndFunctionsFragment extends BaseFragment {

    private ViewPager aspectsAndFunctionsPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_aspects_and_functions, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        initialize();
        aspectsAndFunctionsPager = getAspectsAndFunctionsPager(view);
        aspectsAndFunctionsPager.setAdapter(new AspectAndFunctionsAdapter(getChildFragmentManager()));
        aspectsAndFunctionsPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                    @Override
                    public void onPageSelected(int position) {
                        onPageChanged(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {}
                }
        );
        getSwitchLayout(view).setOnClickListener(v -> switchPage(aspectsAndFunctionsPager.getCurrentItem()));
    }

    private void switchPage(int current){
        switch (current) {
            case AspectAndFunctionsAdapter.FUNCTIONS: {
                aspectsAndFunctionsPager.setCurrentItem(AspectAndFunctionsAdapter.ASPECTS);
                break;
            }
            case AspectAndFunctionsAdapter.ASPECTS:{
                aspectsAndFunctionsPager.setCurrentItem(AspectAndFunctionsAdapter.FUNCTIONS);
                break;
            }
        }
    }

    private void onPageChanged(int current){
        TextView switchText = getSwitchText();

        switch (current) {
            case AspectAndFunctionsAdapter.ASPECTS: {
                getMoreImageButton().setVisibility(View.VISIBLE);
                getLessImageButton().setVisibility(View.INVISIBLE);
                switchText.setText(getResources().getString(R.string.functions_title));
                break;
            }
            case AspectAndFunctionsAdapter.FUNCTIONS:{
                getMoreImageButton().setVisibility(View.INVISIBLE);
                getLessImageButton().setVisibility(View.VISIBLE);
                switchText.setText(getResources().getString(R.string.aspects_title));
                break;
            }
        }
    }

    private ImageButton getMoreImageButton(){
        return getActivity().findViewById(R.id.switch_more_button);
    }

    private ImageButton getLessImageButton(){
        return getActivity().findViewById(R.id.switch_less_button);
    }

    private TextView getSwitchText(){
        return getActivity().findViewById(R.id.switch_text_view);
    }

    private View getSwitchLayout(View view){
        return view.findViewById(R.id.switch_layout);
    }

    private ViewPager getAspectsAndFunctionsPager(View view){
        return view.findViewById(R.id.aspects_and_functions_pager);
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.aspects_and_functions);
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_aspects_and_functions;
    }
}
