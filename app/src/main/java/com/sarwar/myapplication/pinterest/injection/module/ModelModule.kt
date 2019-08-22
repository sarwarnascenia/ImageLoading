package com.sarwar.myapplication.pinterest.injection.module

import  com.sarwar.myapplication.mvload.MVLoadClient
import  com.sarwar.myapplication.pinterest.model.PinterestModel
import  com.sarwar.myapplication.pinterest.model.PinterestModelImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ModelModule {

    @Binds
    abstract fun bindPinterestModel(presenter: PinterestModelImpl): PinterestModel


    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideMVLoadClint(): MVLoadClient {
            return MVLoadClient()
        }
    }
}