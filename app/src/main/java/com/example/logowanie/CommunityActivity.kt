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

class CommunityActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_community)

        intent()
        nawigationLeft()


    }

    fun intent (){
        btRanking = findViewById(R.id.bt_ranking_league)
        btRanking.setOnClickListener{
            val intent = Intent(this, Ranking::class.java)
            startActivity(intent)
        }
        btMap =findViewById(R.id.bt_ranking_mapa)
        btMap.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        btCommunity = findViewById(R.id.bt_ranking_society)
        btCommunity.setOnClickListener{
            Toast.makeText(this, "Już jesteś w Home", Toast.LENGTH_SHORT).show()
        }
        btChat = findViewById(R.id.bt_ranking_chat)
        btChat.setOnClickListener{
            Toast.makeText(this, "Już jesteś w Chat", Toast.LENGTH_SHORT).show()
        }
        btHome = findViewById(R.id.bt_ranking_home)
        btHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }

    fun nawigationLeft (){
        // Pobierz drawer layout z layoutu
        drawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        navigationViewmoje = findViewById(R.id.nav_ranking_view)
        navigationViewmoje.itemIconTintList = null
        // Pobierz przycisk menu z layoutu
        battonMenu = findViewById(R.id.bt_ranking_menu)
        battonMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }





}