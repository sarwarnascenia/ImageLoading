package com.sarwar.myapplication.pinterest.injection

import android.app.Application
import  com.sarwar.myapplication.App
import  com.sarwar.myapplication.pinterest.injection.module.ApplicationModule
import  com.sarwar.myapplication.pinterest.injection.module.ModelModule
import  com.sarwar.myapplication.pinterest.injection.module.PresentationModule
import  com.sarwar.myapplication.pinterest.injection.module.UIModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ApplicationModule::class), (UIModule::class),
    (PresentationModule::class), (ModelModule::class)])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: App)

}