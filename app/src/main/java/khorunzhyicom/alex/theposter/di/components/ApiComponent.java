package khorunzhyicom.alex.theposter.di.components;

import dagger.Subcomponent;
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector;
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector;
import khorunzhyicom.alex.theposter.di.modules.ApiConfigModule;
import khorunzhyicom.alex.theposter.di.modules.ApiModule;
import khorunzhyicom.alex.theposter.di.modules.JanetCommandModule;
import khorunzhyicom.alex.theposter.di.modules.MappingModule;
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScoup;

@ServiceScoup
@Subcomponent(modules = {ApiModule.class, ApiConfigModule.class, JanetCommandModule.class, MappingModule.class } )
public interface ApiComponent extends CommandInjector, PresentationInjector {

}
