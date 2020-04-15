package com.laushkina.anastasia.psychosophy.view.functions;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsDescriptionBinding;
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.utils.TextStylezer;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public abstract class FunctionsDescriptionFragment extends BaseFragment implements IFunctionSelectListener {

    public static final String requestedFunctionExtra = "requestedFunctionExtra";

    private FunctionViewModel viewModel;
    private SlidingUpPanelLayout slidingUpPanel;
    private ScrollView descriptionScrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentFunctionsDescriptionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_functions_description,
                container, false);
        binding.setSelectListener(this);

        View rootView = binding.getRoot();
        initialize(rootView);
        binding.setViewModel(viewModel);
        return rootView;
    }

    private void initialize(View rootView){
        Drawable functionImage = getImage();
        viewModel = getViewModel(functionImage);

        // Sliding panel is unique for each tab - so it should be initialized every time
        slidingUpPanel = rootView.findViewById(R.id.sliding_layout);
        descriptionScrollView = rootView.findViewById(R.id.function_description_scroller);
    }

    @Override
    public void onResume(){
        super.onResume();
        PsychoFunction requestedFunction = getRequestedFunction();
        if (requestedFunction == null) return;

        onFunctionDescriptionRequested(getFullDescription(requestedFunction), getTitle(requestedFunction), getImage(requestedFunction));
    }

    private FunctionViewModel getViewModel(Drawable functionImage){
        return new FunctionViewModel.Builder()
                .functionTitle(getFunctionTitle())
                .functionDescription(TextStylezer.style(getFunctionDescription(), getActivity()))
                .functionImage(functionImage)
                .emotionTitle(getEmotionShortTitle())
                .logicTitle(getLogicShortTitle())
                .physicsTitle(getPhysicsShortTitle())
                .willTitle(getWillShortTitle())
                .build();
    }

    /**
     * @return image of function (general)
     */
    public abstract Drawable getImage();

    /**
     * @return image of concrete function : first logic or third physics
     */
    public abstract Drawable getImage(PsychoFunction function);

    public abstract CharSequence getFunctionDescription();

    public abstract CharSequence getFullDescription(PsychoFunction function);

    public abstract String getEmotionShortTitle();
    public abstract String getEmotionTitle();

    public abstract String getLogicShortTitle();
    public abstract String getLogicTitle();

    public abstract String getPhysicsShortTitle();
    public abstract String getPhysicsTitle();

    public abstract String getWillShortTitle();
    public abstract String getWillTitle();

    private String getTitle(PsychoFunction function) {
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
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Emotion), getEmotionTitle(), getImage(PsychoFunction.Emotion));
    }

    public void onLogicClick(){
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Logic), getLogicTitle(), getImage(PsychoFunction.Logic));
    }

    public void onPhysicsClick(){
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Physics), getPhysicsTitle(), getImage(PsychoFunction.Physics));
    }

    public void onWillClick(){
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Will), getWillTitle(), getImage(PsychoFunction.Will));
    }

    private void onFunctionDescriptionRequested(CharSequence fullDescription, String title, Drawable image){
        viewModel.setFunctionDescription(TextStylezer.style(fullDescription, getActivity()));
        viewModel.setFunctionTitle(title);
        viewModel.setFunctionImage(image);
        collapseBottomNavigation();
        scrollToTheTop();
    }

    private void collapseBottomNavigation(){
        slidingUpPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

    }

    private void scrollToTheTop(){
        descriptionScrollView.smoothScrollTo(0, 0);
    }

    private PsychoFunction getRequestedFunction(){
        return getArguments() == null ? null : (PsychoFunction)getArguments().getSerializable(requestedFunctionExtra);
    }

    @Override
    protected String getTitle() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_functions;
    }
}
