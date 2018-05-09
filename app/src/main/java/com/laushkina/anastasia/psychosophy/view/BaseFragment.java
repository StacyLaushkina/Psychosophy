package com.laushkina.anastasia.psychosophy.view;

import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;

public abstract class BaseFragment extends Fragment {

    protected abstract CharSequence getTitle();

    public void setTitle(){
        TextView toolbar = getToolbar();
        toolbar.setText(getTitle());
    }

    private TextView getToolbar(){
        return getActivity().findViewById(R.id.toolbar_title);
    }

    public NavigationView getNavigationView(){
        return (NavigationView) getActivity().findViewById(R.id.nav_view);
    }
}
