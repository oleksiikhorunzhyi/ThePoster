package khorunzhyicom.alex.theposter.di.components

import dagger.Subcomponent
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.UiModule
import khorunzhyicom.alex.theposter.di.scoupes.ScreenScope

@ScreenScope
@Subcomponent(modules = arrayOf(UiModule::class))
interface ScreenComponent : PresentationInjector
