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

class Ranking : AppCompatActivity() {

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
        setContentView(R.layout.activity_ranking)

        intent()
        val leftMenu : LeftMenu = LeftMenu(this)
        leftMenu.nawigationLeft()
        viewPager2InTabLayout()
    }


    fun intent (){
        btRanking = findViewById(R.id.bt_ranking_league)
        btRanking.setOnClickListener{
            Toast.makeText(this, "Już jesteś w Ranking", Toast.LENGTH_SHORT).show()
        }
        btMap =findViewById(R.id.bt_ranking_mapa)
        btMap.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        btCommunity = findViewById(R.id.bt_ranking_society)
        btCommunity.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("tabIndex", 0)
            startActivity(intent)
        }
        btChat = findViewById(R.id.bt_ranking_chat)
        btChat.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("tabIndex", 2)
            startActivity(intent)
        }
        btHome = findViewById(R.id.bt_ranking_home)
        btHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }

    fun viewPager2InTabLayout (){
        viewPager =findViewById(R.id.vp2_tab_ranking)
        tabLayout = findViewById(R.id.tab_ranking_layout)

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Ranking"
                1 -> "Ligi"
                2 -> "Moje ligi"
                3 -> "Moje mecze"
                else -> ""
            }
        }.attach()
    }








}