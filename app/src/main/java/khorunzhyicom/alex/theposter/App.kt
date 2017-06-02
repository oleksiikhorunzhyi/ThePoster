package khorunzhyicom.alex.theposter

import android.app.Application
import khorunzhyicom.alex.theposter.di.components.ServiceComponent
import khorunzhyicom.alex.theposter.di.components.AppComponent
import khorunzhyicom.alex.theposter.di.components.DaggerAppComponent
import khorunzhyicom.alex.theposter.di.components.UiComponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.*

class App : Application() {

    lateinit var appComponent: AppComponent
    lateinit var serviceComponent: ServiceComponent
    lateinit var uiComponent: UiComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        this.serviceComponent = appComponent.create()
        this.uiComponent = serviceComponent.plus(UiModule())
        this.appComponent.inject(this)
    }

    fun commandInjector(): CommandInjector {
        return serviceComponent
    }

    fun uiInjector(): PresentationInjector {
        return uiComponent
    }
}
