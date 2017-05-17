package khorunzhyicom.alex.theposter.service.commands;

import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector;

public interface InjectableCommand {

    void injectTo(CommandInjector component);
}
