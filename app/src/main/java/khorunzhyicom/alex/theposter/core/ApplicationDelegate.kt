package khorunzhyicom.alex.theposter.core

import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector

interface ApplicationDelegate {

    fun registerInitializers(initializers: MutableSet<AppInitializer>)

    fun onAppReady(initializerInjector: InitializerInjector)
}