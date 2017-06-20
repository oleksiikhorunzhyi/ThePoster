package khorunzhyicom.alex.theposter

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import khorunzhyicom.alex.theposter.di.components.ApplicationComponent
import khorunzhyicom.alex.theposter.di.components.DaggerApplicationComponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector

class App : DaggerApplication() {

    val applicationInjector: AndroidInjector<out DaggerApplication> by lazy { DaggerApplicationComponent.builder().create(this) }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

    fun appComponent(): ApplicationComponent = applicationInjector as ApplicationComponent
    fun commandInjector(): CommandInjector = applicationInjector as CommandInjector
    fun initializerInjector(): InitializerInjector = applicationInjector as InitializerInjector

}
