package khorunzhyicom.alex.theposter

import android.app.Application

import khorunzhyicom.alex.theposter.di.components.ApiComponent
import khorunzhyicom.alex.theposter.di.components.AppComponent
import khorunzhyicom.alex.theposter.di.components.DaggerAppComponent
import khorunzhyicom.alex.theposter.di.components.UiComponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.ApiModule
import khorunzhyicom.alex.theposter.di.modules.AppModule
import khorunzhyicom.alex.theposter.di.modules.UiModule

class App : Application() {

    lateinit var appComponent: AppComponent
    lateinit var apiComponent: ApiComponent
    lateinit var uiComponent: UiComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        this.apiComponent = appComponent.plus(ApiModule())
        this.uiComponent = apiComponent.plus(UiModule())
        this.appComponent.inject(this)
    }

    fun commandInjector(): CommandInjector {
        return apiComponent
    }

    fun uiInjector(): PresentationInjector {
        return uiComponent
    }
}
