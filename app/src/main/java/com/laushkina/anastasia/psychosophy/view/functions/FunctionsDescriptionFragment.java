package com.laushkina.anastasia.psychosophy.view.functions;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsDescriptionBinding;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.utils.TextStylezer;

public abstract class FunctionsDescriptionFragment extends BaseFragment implements IFunctionSelectListener {

    public static final String requestedFunctionExtra = "requestedFunctionExtra";

    private FunctionViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentFunctionsDescriptionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_functions_description,
                container, false);
        binding.setSelectListener(this);

        initialize();
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    private void initialize(){
        Drawable functionImage = getImage();
        viewModel = getViewModel(functionImage);
    }

    @Override
    public void onResume(){
        super.onResume();
        Function requestedFunction = getRequestedFunction();
        if (requestedFunction == null) return;

        onFullDescriptionRequested(getFullDescription(requestedFunction), getTitle(requestedFunction), getImage(requestedFunction));
    }

    private FunctionViewModel getViewModel(Drawable functionImage){
        return new FunctionViewModel.Builder()
                .functionTitle(getFunctionTitle())
                .functionDescription(TextStylezer.style(getFunctionDescription(), getActivity()))
                .functionImage(functionImage)
                .emotionTitle(getFunctionPrefix() + getEmotionTitle())
                .logicTitle(getFunctionPrefix() + getLogicTitle())
                .physicsTitle(getFunctionPrefix() + getPhysicsTitle())
                .willTitle(getFunctionPrefix() + getWillTitle())
                .build();
    }

    /**
     * @return image of function (general)
     */
    public abstract Drawable getImage();

    /**
     * @return image of concrete function : first logic or third physics
     */
    public abstract Drawable getImage(Function function);

    public abstract CharSequence getFunctionDescription();

    public abstract CharSequence getFullDescription(Function function);

    public abstract String getEmotionTitle();

    public abstract String getLogicTitle();

    public abstract String getPhysicsTitle();

    public abstract String getWillTitle();

    public abstract String getFunctionPrefix();

    private String getTitle(Function function) {
        switch (function) {
            case Will: return getWillTitle();
            case Physics: return getPhysicsTitle();
            case Logic: return getLogicTitle();
            case Emotion: return getEmotionTitle();
            default: throw new AssertionError();
        }
    }
    private String getFunctionTitle(){
        return getResources().getString(R.string.common_description_title);
    }


    public void onEmotionClick(){
        onFullDescriptionRequested(getFullDescription(Function.Emotion), getEmotionTitle(), getImage(Function.Emotion));
    }

    public void onLogicClick(){
        onFullDescriptionRequested(getFullDescription(Function.Logic), getLogicTitle(), getImage(Function.Logic));
    }

    public void onPhysicsClick(){
        onFullDescriptionRequested(getFullDescription(Function.Physics), getPhysicsTitle(), getImage(Function.Physics));
    }

    public void onWillClick(){
        onFullDescriptionRequested(getFullDescription(Function.Will), getWillTitle(), getImage(Function.Will));
    }

    private void onFullDescriptionRequested(CharSequence fullDescription, String title, Drawable image){
        viewModel.setFunctionDescription(TextStylezer.style(fullDescription, getActivity()));
        viewModel.setFunctionTitle(title);
        viewModel.setFunctionImage(image);
    }

    @Override
    protected String getTitle() {
        throw new UnsupportedOperationException();
    }

    private Function getRequestedFunction(){
        return getArguments() == null ? null : (Function)getArguments().getSerializable(requestedFunctionExtra);
    }
}
