package khorunzhyicom.alex.theposter.service.providers

import khorunzhyicom.alex.theposter.service.interactors.ConfigurationInteractor
import khorunzhyicom.alex.theposter.service.models.Configuration
import rx.Observable

class ConfigurationProvider(val configInteractor: ConfigurationInteractor) : StreamProvider<Configuration> {

    override fun provide(): Observable<Configuration> = configInteractor
            .pipe()
            .observeSuccessWithReplay()
            .map { it.result }
}