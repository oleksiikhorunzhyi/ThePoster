package khorunzhyicom.alex.theposter.presentation.activity.common


import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.activity.PosterActivity

class PosterDrawerInitializer : Initializer<PosterActivity> {

    override fun initialize(activity: PosterActivity) {
        val toolbar = activity.findViewById(R.id.toolbar) as Toolbar
        val drawer = activity.findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(activity, drawer, toolbar, R.string.drawer_open, R.string.drawer_close)

        activity.setSupportActionBar(toolbar)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }
}
