package khorunzhyicom.alex.theposter.service.commands.base

import io.techery.janet.Command

abstract class ApiCommand<R> : Command<R>(), InjectableCommand
