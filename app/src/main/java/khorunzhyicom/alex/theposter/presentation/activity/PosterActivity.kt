package khorunzhyicom.alex.theposter.presentation.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.RouterTransaction
import khorunzhyicom.alex.theposter.R

class PosterActivity : DaggerActivity() {

    lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close)

        setSupportActionBar(toolbar)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val container = findViewById(R.id.controller_container) as ViewGroup
        val router = Conductor.attachRouter(this, container, savedInstanceState)
        router.setRoot(RouterTransaction.with(PosterController()))
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
