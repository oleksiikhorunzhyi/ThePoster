package khorunzhyicom.alex.theposter.service.commands.base

import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector

interface InjectableCommand {

    fun injectTo(component: CommandInjector)
}
