package com.laushkina.anastasia.psychosophy.view.functions;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsOrderBinding;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public abstract class FunctionsOrderFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentFunctionsOrderBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_functions_order,
                container, false);
        binding.setFragment(getFragment());
        binding.setViewModel(getViewModel());

        return binding.getRoot();
    }

    private FunctionViewModel getViewModel(){
        return new FunctionViewModel.Builder()
                .functionDescription(getFunctionDescription())
                .functionImage(getImage())
                .emotionTitle(getFunctionPrefix() + getEmotionTitle())
                .logicTitle(getFunctionPrefix() + getLogicTitle())
                .physicsTitle(getFunctionPrefix() + getPhysicsTitle())
                .willTitle(getFunctionPrefix() + getWillTitle())
                .build();
    }

    public abstract Drawable getImage();

    public abstract String getFunctionDescription();

    public abstract String getEmotionTitle();

    public abstract String getEmotionFullDescription();

    public abstract String getLogicTitle();

    public abstract String getLogicFullDescription();

    public abstract String getPhysicsTitle();

    public abstract String getPhysicsFullDescription();

    public abstract String getWillTitle();

    public abstract String getWillFullDescription();

    public abstract String getFunctionPrefix();

    abstract FunctionsOrderFragment getFragment();

    public void onEmotionClick(){
        onFullDescriptionRequested(getEmotionFullDescription());
    }

    public void onLogicClick(){
        onFullDescriptionRequested(getLogicFullDescription());
    }

    public void onPhysicsClick(){
        onFullDescriptionRequested(getPhysicsFullDescription());
    }

    public void onWillClick(){
        onFullDescriptionRequested(getWillFullDescription());
    }

    private void onFullDescriptionRequested(String fullDescription){
        getOverviewView().setVisibility(View.GONE);
        TextView descriptionView = getFullDescriptionView();
        descriptionView.setVisibility(View.VISIBLE);
        descriptionView.setText(fullDescription);
    }

    @Override
    protected String getTitle() {
        throw new UnsupportedOperationException();
    }

    private View getOverviewView(){
        return getActivity().findViewById(R.id.function_overview);
    }

    private TextView getFullDescriptionView(){
        return getActivity().findViewById(R.id.full_function_description);
    }

}
