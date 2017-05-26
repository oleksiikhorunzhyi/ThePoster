package khorunzhyicom.alex.theposter.di.components.injector


import khorunzhyicom.alex.theposter.App

interface AppInjector : Injector {

    fun inject(app: App)
}
