package khorunzhyicom.alex.theposter.core

import khorunzhyicom.alex.theposter.App

class PosterAppInitializer(val app: App, val initializers: MutableSet<AppInitializer>) {

    fun initialize() {
        val injector = app.initializerInjector()

        initializers.forEach { it.inject(injector) }
        initializers.forEach { it.initialize() }
    }
}