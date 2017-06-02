package khorunzhyicom.alex.theposter.service.interactors

import io.techery.janet.ActionPipe
import io.techery.janet.Janet
import io.techery.janet.ReadActionPipe
import khorunzhyicom.alex.theposter.service.commands.configuration.GetConfigurationCommand
import khorunzhyicom.alex.theposter.service.commands.ext.createPipe
import rx.schedulers.Schedulers

class ConfigurationInteractor(janet: Janet) {

    private val nowPlayingMoviesPipe: ActionPipe<GetConfigurationCommand> = janet.createPipe(GetConfigurationCommand::class, Schedulers.io())

    fun pipe(): ReadActionPipe<GetConfigurationCommand> = nowPlayingMoviesPipe

    fun requestConfiguration() = nowPlayingMoviesPipe.send(GetConfigurationCommand())
}