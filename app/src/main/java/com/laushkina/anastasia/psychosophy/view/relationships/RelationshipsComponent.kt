package com.laushkina.anastasia.psychosophy.view.relationships

import dagger.Component

@Component(modules = [RelationshipsPresenter::class])
interface RelationshipsComponent {
    fun getPresenter(): RelationshipsPresenter
}