package com.laushkina.anastasia.psychosophy.view.basesAndFunctions;

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

public class BasesAndFunctionsFragment extends BaseFragment {

    private ViewPager basesAndFunctionsPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_bases_and_functions, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        initialize();
        basesAndFunctionsPager = getBasesAndFunctionsPager(view);
        basesAndFunctionsPager.setAdapter(new BasesAndFunctionsAdapter(getChildFragmentManager()));
        basesAndFunctionsPager.addOnPageChangeListener(
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
        getSwitchLayout(view).setOnClickListener(v -> switchPage(basesAndFunctionsPager.getCurrentItem()));
    }

    private void switchPage(int current){
        switch (current) {
            case BasesAndFunctionsAdapter.FUNCTIONS: {
                basesAndFunctionsPager.setCurrentItem(BasesAndFunctionsAdapter.BASES);
                break;
            }
            case BasesAndFunctionsAdapter.BASES:{
                basesAndFunctionsPager.setCurrentItem(BasesAndFunctionsAdapter.FUNCTIONS);
                break;
            }
        }
    }

    private void onPageChanged(int current){
        TextView switchText = getSwitchText();

        switch (current) {
            case BasesAndFunctionsAdapter.BASES: {
                getMoreImageButton().setVisibility(View.VISIBLE);
                getLessImageButton().setVisibility(View.INVISIBLE);
                switchText.setText(getResources().getString(R.string.functions_title));
                break;
            }
            case BasesAndFunctionsAdapter.FUNCTIONS:{
                getMoreImageButton().setVisibility(View.INVISIBLE);
                getLessImageButton().setVisibility(View.VISIBLE);
                switchText.setText(getResources().getString(R.string.bases_title));
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

    private ViewPager getBasesAndFunctionsPager(View view){
        return view.findViewById(R.id.bases_and_functions_pager);
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.bases_and_functions);
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_bases_and_functions;
    }
}
