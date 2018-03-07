package com.laushkina.anastasia.psychosophy.view.welcome;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.laushkina.anastasia.psychosophy.view.MainActivity;
import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.ActivityWelcomeBinding;
import com.laushkina.anastasia.psychosophy.domain.Screen;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ActivityWelcomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        binding.setActivity(this);
    }

    public void startTest(){
        Intent startTest = new Intent(this, MainActivity.class);
        startTest.putExtra(MainActivity.screenNameExtra, Screen.test);
        startActivity(startTest);
    }

    public void learnTheory(){
        Intent startTest = new Intent(this, MainActivity.class);
        startTest.putExtra(MainActivity.screenNameExtra, Screen.psychotypes);
        startActivity(startTest);
    }
}
