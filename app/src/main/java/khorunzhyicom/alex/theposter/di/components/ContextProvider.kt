package khorunzhyicom.alex.theposter.di.components


import android.content.Context
import android.content.res.Resources

import khorunzhyicom.alex.theposter.App

interface ContextProvider {

    fun application(): App
    fun context(): Context
    fun resources(): Resources
}
