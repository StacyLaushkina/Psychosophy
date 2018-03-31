package com.laushkina.anastasia.psychosophy.view.relationships;

import dagger.Component;

@Component(modules = {RelationshipsPresenter.class})
public interface RelationshipsComponent {
    RelationshipsPresenter getPresenter();
}
