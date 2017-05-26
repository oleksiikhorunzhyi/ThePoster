package khorunzhyicom.alex.theposter.di.components

import javax.inject.Singleton

import dagger.Component
import khorunzhyicom.alex.theposter.di.components.injector.AppInjector
import khorunzhyicom.alex.theposter.di.modules.ApiModule
import khorunzhyicom.alex.theposter.di.modules.AppModule

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent : AppInjector, ContextProvider {

    operator fun plus(apiModule: ApiModule): ApiComponent
}
