package com.example.logowanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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

    private lateinit var viewPager : ViewPager2
    private lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        intent()
        val leftMenu : LeftMenu = LeftMenu(this)
        leftMenu.nawigationLeft()
        viewPager2InTabLayout()
        val selectedTab = intent.getIntExtra("tabIndex", 0)
        viewPager.currentItem = selectedTab



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
            viewPager.currentItem = 0
        }
        btChat = findViewById(R.id.bt_ranking_chat)
        btChat.setOnClickListener{
            viewPager.currentItem = 2
        }
        btHome = findViewById(R.id.bt_ranking_home)
        btHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }

    fun viewPager2InTabLayout (){
        viewPager =findViewById(R.id.vp2_tab_players)
        tabLayout = findViewById(R.id.tab_community_layout)

        viewPager.adapter = ViewPagerAdapterCommunity(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "WYSZUKAJ GRACZA"
                1 -> "ZNAJOMI"
                2 -> "CZAT"
                else -> ""
            }
        }.attach()
    }





}