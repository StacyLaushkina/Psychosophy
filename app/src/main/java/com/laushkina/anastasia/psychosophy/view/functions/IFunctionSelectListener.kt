package com.laushkina.anastasia.psychosophy.view.functions

import android.view.View

interface IFunctionSelectListener {
    fun onEmotionClick(view: View)
    fun onLogicClick(view: View)
    fun onPhysicsClick(view: View)
    fun onWillClick(view: View)
}