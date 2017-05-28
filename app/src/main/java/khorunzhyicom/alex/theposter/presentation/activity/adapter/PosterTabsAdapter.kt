package khorunzhyicom.alex.theposter.presentation.activity.adapter


import android.content.Context

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter

class PosterTabsAdapter(host: Controller, val context: Context, val tabs: List<TabView>) : RouterPagerAdapter(host) {

    override fun configureRouter(router: Router, position: Int) {
        if (!router.hasRootController()) {
            val controller = tabs[position].tabController()
            router.pushController(RouterTransaction.with(controller))
        }
    }

    override fun getCount(): Int = tabs.size

    override fun getPageTitle(position: Int): CharSequence = context.getString(tabs[position].tabTitle())

}

