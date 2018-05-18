package com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class AspectsAndFunctions_FunctionsFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_aspects_and_functions_functions, container, false);
        initialize(view);
        return view;
    }

    private void initialize(View view){
        TextView firstFunction = view.findViewById(R.id.first_function_text);
        firstFunction.setText(Html.fromHtml(getResources().getString(R.string.functions_info_first)));

        TextView secondFunction = view.findViewById(R.id.second_function_text);
        secondFunction.setText(Html.fromHtml(getResources().getString(R.string.functions_info_second)));

        TextView thirdFunction = view.findViewById(R.id.third_function_text);
        thirdFunction.setText(Html.fromHtml(getResources().getString(R.string.functions_info_third)));

        TextView forthFunction = view.findViewById(R.id.forth_function_text);
        forthFunction.setText(Html.fromHtml(getResources().getString(R.string.functions_info_forth)));

        TextView moreInfo = view.findViewById(R.id.function_info_text);
        moreInfo.setText(Html.fromHtml(getResources().getString(R.string.functions_info)));
//        moreInfo.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }
}
