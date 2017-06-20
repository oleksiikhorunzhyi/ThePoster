package khorunzhyicom.alex.theposter

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import khorunzhyicom.alex.theposter.di.components.ApplicationComponent
import khorunzhyicom.alex.theposter.di.components.DaggerApplicationComponent
import khorunzhyicom.alex.theposter.di.components.ServiceComponent
import khorunzhyicom.alex.theposter.di.components.UiComponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.UiModule

class App : DaggerApplication() {

    val applicationInjector: AndroidInjector<out DaggerApplication> by lazy { DaggerApplicationComponent.builder().create(this) }

    override fun onCreate() {
        super.onCreate()
        serviceComponent = (applicationInjector as ApplicationComponent).createServiceComponent()
        uiComponent = serviceComponent.create(UiModule())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

    fun commandInjector(): CommandInjector = serviceComponent
    fun initializerInjector(): InitializerInjector = serviceComponent
    fun uiInjector(): PresentationInjector = uiComponent

    companion object {
        lateinit var serviceComponent: ServiceComponent
        lateinit var uiComponent: UiComponent
    }

}
