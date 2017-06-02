package khorunzhyicom.alex.theposter.di.components

import dagger.Component
import khorunzhyicom.alex.theposter.di.components.injector.AppInjector
import khorunzhyicom.alex.theposter.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent : AppInjector {

    fun create(): ServiceComponent
}
