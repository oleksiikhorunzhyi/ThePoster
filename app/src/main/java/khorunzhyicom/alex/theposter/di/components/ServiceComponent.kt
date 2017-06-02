package khorunzhyicom.alex.theposter.di.components

import dagger.Subcomponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.modules.ApiConfigModule
import khorunzhyicom.alex.theposter.di.modules.InteractorsModule
import khorunzhyicom.alex.theposter.di.modules.JanetModule
import khorunzhyicom.alex.theposter.di.modules.MappingModule
import khorunzhyicom.alex.theposter.di.modules.UiModule
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope

@ServiceScope
@Subcomponent(modules = arrayOf(InteractorsModule::class, ApiConfigModule::class, JanetModule::class, MappingModule::class))
interface ServiceComponent : CommandInjector {

    fun plus(uiModule: UiModule): UiComponent

}