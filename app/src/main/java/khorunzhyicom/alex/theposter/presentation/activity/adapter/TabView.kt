package khorunzhyicom.alex.theposter.presentation.activity.adapter

import android.support.annotation.StringRes
import com.bluelinelabs.conductor.Controller


interface TabView {

    fun controller(): Controller

    @StringRes fun title(): Int
}