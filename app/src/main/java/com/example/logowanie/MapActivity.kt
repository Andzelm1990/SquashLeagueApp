package com.example.logowanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MapActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var battonMenu : ImageButton
    private lateinit var navigationViewmoje : NavigationView
    private lateinit var rvHomeNews : RecyclerView

    private lateinit var btRanking : ImageButton
    private lateinit var btMap : ImageButton
    private lateinit var btCommunity : ImageButton
    private lateinit var btChat : ImageButton
    private lateinit var btHome : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        nawigationLeft()
        intent()
    }


    fun nawigationLeft (){
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

    fun intent (){
        btRanking = findViewById(R.id.bt_home_league)
        btRanking.setOnClickListener{
            val intent = Intent(this, Ranking::class.java)
            startActivity(intent)
        }
        btMap =findViewById(R.id.bt_home_mapa)
        btMap.setOnClickListener{
            Toast.makeText(this, "Już jesteś w Mapa", Toast.LENGTH_SHORT).show()
        }
        btCommunity = findViewById(R.id.bt_home_society)
        btCommunity.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            startActivity(intent)
        }
        btChat = findViewById(R.id.bt_home_chat)
        btChat.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            startActivity(intent)
        }
        btHome = findViewById(R.id.bt_home_home)
        btHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }




}