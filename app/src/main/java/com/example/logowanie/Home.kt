package com.example.logowanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var battonMenu : ImageButton
    private lateinit var navigationViewmoje : NavigationView
    private lateinit var rvHomeNews : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvHomeNews = findViewById(R.id.rv_home_news)
        rvHomeNews.layoutManager = LinearLayoutManager(this)
        rvHomeNews.adapter = MyAdapter()




        // Pobierz drawer layout z layoutu
        drawerLayout = findViewById(R.id.drawer_layout)

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        navigationViewmoje = findViewById(R.id.nav_view)
        navigationViewmoje.itemIconTintList = null
        // Pobierz przycisk menu z layoutu
        battonMenu = findViewById(R.id.bt_home_menu)
        battonMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }


    }




}