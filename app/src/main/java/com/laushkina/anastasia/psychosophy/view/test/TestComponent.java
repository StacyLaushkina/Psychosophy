package com.laushkina.anastasia.psychosophy.view.test;

import dagger.Component;

@Component(modules = {TestPresenter.class})
public interface TestComponent {
    TestPresenter getPresenter();
}
