package khorunzhyicom.alex.theposter.presentation.activity.adapter

import android.support.annotation.StringRes
import com.bluelinelabs.conductor.Controller


interface TabView {

    fun tabController(): Controller

    @StringRes fun tabTitle(): Int
}