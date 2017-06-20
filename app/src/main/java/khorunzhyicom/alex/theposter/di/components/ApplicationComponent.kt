package khorunzhyicom.alex.theposter.di.components

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.modules.AppModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class, AndroidInjectionModule::class))
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder abstract class Builder : AndroidInjector.Builder<App>()

    fun createServiceComponent(): ServiceComponent
}
