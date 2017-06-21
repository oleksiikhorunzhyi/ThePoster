package khorunzhyicom.alex.theposter.di.components

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.di.modules.*
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, InitializerModule::class, InteractorsModule::class, ApiConfigModule::class, JanetModule::class, ConverterModule::class))
interface ApplicationComponent : AndroidInjector<App>, CommandInjector, InitializerInjector {

    @Component.Builder abstract class Builder : AndroidInjector.Builder<App>()

    fun plus(uiModule: UiModule): UiComponent
}
