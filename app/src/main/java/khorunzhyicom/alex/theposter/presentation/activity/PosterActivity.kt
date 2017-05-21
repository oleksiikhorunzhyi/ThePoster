package khorunzhyicom.alex.theposter.presentation.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.RouterTransaction
import khorunzhyicom.alex.theposter.App
import khorunzhyicom.alex.theposter.R
import khorunzhyicom.alex.theposter.presentation.activity.common.PosterDrawerInitializer
import javax.inject.Inject

class PosterActivity : AppCompatActivity() {

    @Inject lateinit var drawerInitializer: PosterDrawerInitializer

    internal var drawer: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as App).uiComponent().inject(this)

        drawerInitializer.initialize(this)
        drawer = findViewById(R.id.drawer_layout) as DrawerLayout

        val container = findViewById(R.id.controller_container) as ViewGroup
        val router = Conductor.attachRouter(this, container, savedInstanceState)
        router.setRoot(RouterTransaction.with(PosterController()))
    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
