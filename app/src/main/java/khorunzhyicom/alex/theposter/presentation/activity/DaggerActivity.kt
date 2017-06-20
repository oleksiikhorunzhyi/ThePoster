package khorunzhyicom.alex.theposter.presentation.activity

import android.support.v7.app.AppCompatActivity
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.di.components.injector.PresentationInjector
import khorunzhyicom.alex.theposter.di.modules.UiModule
import khorunzhyicom.alex.theposter.presentation.common.view.Injectable

abstract class DaggerActivity : AppCompatActivity(), Injectable<PresentationInjector> {

    val injector: PresentationInjector by lazy { (applicationContext as App).appComponent().plus(UiModule()) }

    override fun injector(): PresentationInjector = injector
}