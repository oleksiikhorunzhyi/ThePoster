package khorunzhyicom.alex.theposter.di.components

import dagger.Subcomponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.di.modules.*
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope

@ServiceScope
@Subcomponent(modules = arrayOf(InitializerModule::class, InteractorsModule::class, ApiConfigModule::class, JanetModule::class, MappingModule::class))
interface ServiceComponent : CommandInjector, InitializerInjector {

    fun create(uiModule: UiModule): UiComponent
}
