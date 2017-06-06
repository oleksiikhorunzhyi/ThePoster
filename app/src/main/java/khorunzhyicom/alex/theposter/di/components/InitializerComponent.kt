package khorunzhyicom.alex.theposter.di.components

import dagger.Subcomponent
import khorunzhyicom.alex.theposter.di.components.injector.InitializerInjector
import khorunzhyicom.alex.theposter.di.modules.InitializerModule
import khorunzhyicom.alex.theposter.di.modules.UiModule
import khorunzhyicom.alex.theposter.di.scoupes.InitializeScoupe

@InitializeScoupe
@Subcomponent(modules = arrayOf(InitializerModule::class))
interface InitializerComponent : InitializerInjector {

    fun create(uiModule: UiModule): UiComponent
}