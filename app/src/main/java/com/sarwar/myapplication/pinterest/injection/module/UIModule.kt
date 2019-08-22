package com.sarwar.myapplication.pinterest.injection.module

import  com.sarwar.myapplication.pinterest.view.MainActivity
import  com.sarwar.myapplication.pinterest.view.PinterestListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UIModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributePinterestListFragment(): PinterestListFragment

}