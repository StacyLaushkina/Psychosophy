package com.laushkina.anastasia.psychosophy.view;

import android.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.laushkina.anastasia.psychosophy.R;

public abstract class BaseFragment extends Fragment {

    protected abstract CharSequence getTitle();

    public void setTitle(){
        Toolbar toolbar = getToolbar();
        toolbar.setTitle(getTitle());
    }

    private Toolbar getToolbar(){
        return getActivity().findViewById(R.id.toolbar);
    }
}
