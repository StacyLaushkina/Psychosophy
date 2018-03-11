package com.laushkina.anastasia.psychosophy.view.functions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class FirstFunctionFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);


        View view = inflater.inflate(R.layout.fragment_functions_order, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        TextView desc = view.findViewById(R.id.order_function_description);
        desc.setText(R.string.first_function_description);

        Button logic = view.findViewById(R.id.logic_position);
        logic.setText("1L");
        Button emotion = view.findViewById(R.id.emotion_position);
        emotion.setText("1E");
        Button physics = view.findViewById(R.id.physics_position);
        physics.setText("1P");
        Button will = view.findViewById(R.id.will_position);
        will.setText("1W");
    }

    @Override
    protected String getTitle() {
        throw new UnsupportedOperationException();
    }
}
