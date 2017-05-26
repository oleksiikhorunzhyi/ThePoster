package khorunzhyicom.alex.theposter.di.components

import dagger.Subcomponent
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.UiModule
import khorunzhyicom.alex.theposter.di.scoupes.UIScope

@UIScope
@Subcomponent(modules = arrayOf(UiModule::class))
interface UiComponent : PresentationInjector
