package khorunzhyicom.alex.theposter.presentation.activity.adapter


import android.content.Context
import android.content.res.Resources

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter

class PosterTabsAdapter(host: Controller, val context: Context, val tabs: List<TabView>) : RouterPagerAdapter(host) {

    init {
        setMaxPagesToStateSave(tabs.size)
    }

    override fun configureRouter(router: Router, position: Int) {
        if (!router.hasRootController()) {
            val controller = tabs[position].controller()
            router.pushController(RouterTransaction.with(controller))
        }
    }

    override fun getCount(): Int {
        return tabs.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.getString(tabs[position].title())
    }

}

