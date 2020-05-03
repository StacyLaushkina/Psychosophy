package com.laushkina.anastasia.psychosophy.view.test

import dagger.Component

@Component(modules = [TestPresenter::class])
interface TestComponent {
    fun getPresenter(): TestPresenter
}