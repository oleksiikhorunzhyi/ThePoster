package khorunzhyicom.alex.theposter.core

import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector


interface InjectableInitializer {

    fun inject(injector: InitializerInjector)
}