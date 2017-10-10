package khorunzhyicom.alex.theposter.core

import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.service.interactors.ConfigurationInteractor
import javax.inject.Inject

class ConfigurationInitializer : AppInitializer {

    @Inject lateinit var configInteractor: ConfigurationInteractor

    override fun initialize() = configInteractor.requestConfiguration()

    override fun inject(injector: InitializerInjector) = injector.inject(this)

}