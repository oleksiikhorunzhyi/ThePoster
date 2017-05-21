package khorunzhyicom.alex.theposter.di.components;

import dagger.Subcomponent;
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector;
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.di.modules.ApiConfigModule;
import khorunzhyicom.alex.theposter.di.modules.ApiModule;
import khorunzhyicom.alex.theposter.di.modules.JanetCommandModule;
import khorunzhyicom.alex.theposter.di.modules.MappingModule;
import khorunzhyicom.alex.theposter.di.modules.UiModule;
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope;

@ServiceScope
@Subcomponent(modules = { ApiModule.class, ApiConfigModule.class, JanetCommandModule.class, MappingModule.class } )
public interface ApiComponent extends CommandInjector {

    UiComponent plus(UiModule uiModule);

}
