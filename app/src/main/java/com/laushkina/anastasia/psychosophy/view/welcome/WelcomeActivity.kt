package com.laushkina.anastasia.psychosophy.view.welcome

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.ActivityWelcomeBinding
import com.laushkina.anastasia.psychosophy.view.MainActivity
import com.laushkina.anastasia.psychosophy.view.Screen

class WelcomeActivity: Activity(), INavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val binding = DataBindingUtil.setContentView<ActivityWelcomeBinding>(this, R.layout.activity_welcome)
        binding.setNavigator(this)
    }

    override fun startTest() {
        val startTest = Intent(this, MainActivity::class.java)
        startTest.putExtra(MainActivity.SCREEN_NAME_EXTRA, Screen.TEST)
        startActivity(startTest)
    }

    override fun learnTheory() {
        val startTest = Intent(this, MainActivity::class.java)
        startTest.putExtra(MainActivity.SCREEN_NAME_EXTRA, Screen.INTRODUCTION)
        startActivity(startTest)
    }
}