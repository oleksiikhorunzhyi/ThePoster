package khorunzhyicom.alex.theposter.service.commands.configuration

import io.techery.janet.Janet
import io.techery.janet.command.annotations.CommandAction
import khorunzhyicom.alex.theposter.api.actions.configuration.ConfigurationHttpAction
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.service.commands.base.ApiCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe
import khorunzhyicom.alex.theposter.service.commands.ext.transformWith
import khorunzhyicom.alex.theposter.service.mappers.ConfigurationMapper
import khorunzhyicom.alex.theposter.service.models.Configuration
import javax.inject.Inject


@CommandAction
class GetConfigurationCommand : ApiCommand<Configuration>() {

    @Inject lateinit var janet: Janet
    @Inject lateinit var mapper: ConfigurationMapper

    override fun injectTo(component: CommandInjector) = component.inject(this)


    @Throws(Throwable::class)
    override fun run(callback: CommandCallback<Configuration>) {
        janet.createPipe(ConfigurationHttpAction::class)
                .createObservableResult(ConfigurationHttpAction())
                .transformWith({ mapper.map(it) })
                .subscribe({ callback.onSuccess(it) }, { callback.onFail(it) })
    }
}