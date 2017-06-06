package khorunzhyicom.alex.theposter.di.components.injector

import khorunzhyicom.alex.theposter.core.ConfigurationInitializer

interface InitializerInjector : Injector {

    fun inject(initializer: ConfigurationInitializer)
}