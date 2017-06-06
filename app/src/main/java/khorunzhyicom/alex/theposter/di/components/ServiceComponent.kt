package khorunzhyicom.alex.theposter.di.components

import dagger.Subcomponent
import khorunzhyicom.alex.theposter.di.components.injector.CommandInjector
import khorunzhyicom.alex.theposter.di.modules.*
import khorunzhyicom.alex.theposter.di.scoupes.ServiceScope

@ServiceScope
@Subcomponent(modules = arrayOf(InteractorsModule::class, ApiConfigModule::class, JanetModule::class, MappingModule::class))
interface ServiceComponent : CommandInjector {

    fun create(): InitializerComponent
}
