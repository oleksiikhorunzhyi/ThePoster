package khorunzhyicom.alex.theposter.core

import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector


class PosterApplicationDelegate : ApplicationDelegate {

    lateinit var initializers: Set<AppInitializer>

    override fun registerInitializers(initializers: MutableSet<AppInitializer>) {
        this.initializers = initializers
    }

    override fun onAppReady(initializerInjector: InitializerInjector) {
        initializers.forEach { it.inject(initializerInjector) }
        initializers.forEach { it.initialize() }
    }

}