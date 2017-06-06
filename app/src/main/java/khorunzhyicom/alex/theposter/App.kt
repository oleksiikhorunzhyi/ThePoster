package khorunzhyicom.alex.theposter

import android.app.Application
import khorunzhyicom.alex.theposter.di.components.*
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.AppModule
import khorunzhyicom.alex.theposter.di.modules.UiModule

class App : Application() {

    lateinit var appComponent: AppComponent
    lateinit var serviceComponent: ServiceComponent
    lateinit var initializerComponent: InitializerComponent
    lateinit var uiComponent: UiComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        this.serviceComponent = appComponent.create()
        this.initializerComponent = serviceComponent.create()
        this.uiComponent = initializerComponent.create(UiModule())

        appComponent.inject(this)
    }

    fun commandInjector(): CommandInjector = serviceComponent
    fun initializerInjector(): InitializerInjector = initializerComponent
    fun uiInjector(): PresentationInjector = uiComponent

}
