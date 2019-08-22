package com.sarwar.myapplication.pinterest.injection.module

import  com.sarwar.myapplication.pinterest.contract.PinterestContract
import  com.sarwar.myapplication.pinterest.presenter.PinterestPresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PresentationModule {

    @Binds
    abstract fun bindProjectsPresenter(presenter: PinterestPresenterImpl): PinterestContract.PinterestPresenter
}