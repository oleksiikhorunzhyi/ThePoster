package khorunzhyicom.alex.theposter

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import khorunzhyicom.alex.theposter.core.PosterAppInitializer
import khorunzhyicom.alex.theposter.di.components.ApplicationComponent
import khorunzhyicom.alex.theposter.di.components.DaggerApplicationComponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject lateinit var appInitializer: PosterAppInitializer

    val applicationInjector: AndroidInjector<out DaggerApplication> by lazy { DaggerApplicationComponent.builder().create(this) }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

    override fun onCreate() {
        super.onCreate()
        appInitializer.initialize()
    }

    fun appComponent(): ApplicationComponent = applicationInjector as ApplicationComponent
    fun commandInjector(): CommandInjector = applicationInjector as CommandInjector
    fun initializerInjector(): InitializerInjector = applicationInjector as InitializerInjector

}
