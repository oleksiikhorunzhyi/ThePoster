package khorunzhyicom.alex.theposter

import android.app.Application
import khorunzhyicom.alex.theposter.di.components.*
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.AppModule
import khorunzhyicom.alex.theposter.di.modules.UiModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var serviceComponent: ServiceComponent
        lateinit var uiComponent: UiComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        serviceComponent = appComponent.create()
        uiComponent = serviceComponent.create(UiModule())

        appComponent.inject(this)
    }

    fun commandInjector(): CommandInjector = serviceComponent
    fun initializerInjector(): InitializerInjector = serviceComponent
    fun uiInjector(): PresentationInjector = uiComponent

}
