package com.example.logowanie

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logowanie.entity.Article
import com.example.logowanie.service.ApiArticleConector
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var rvHomeNews : RecyclerView

    private lateinit var btRanking : ImageButton
    private lateinit var btMap : ImageButton
    private lateinit var btCommunity : ImageButton
    private lateinit var btChat : ImageButton
    private lateinit var btHome : ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        intent()
        createRecyclerView()
        val leftMenu : LeftMenu = LeftMenu(this)
        leftMenu.nawigationLeft()

    }

    fun createRecyclerView () {
        rvHomeNews = findViewById(R.id.rv_home_news)
        rvHomeNews.layoutManager = LinearLayoutManager(this)
        var articles = ApiArticleConector.downloadArticles()

        rvHomeNews.adapter = MyAdapter(articles)

    }

    fun intent (){
        btRanking = findViewById(R.id.bt_home_league)
        btRanking.setOnClickListener{
            val intent = Intent(this, Ranking::class.java)
            startActivity(intent)
        }
        btMap =findViewById(R.id.bt_home_mapa)
        btMap.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        btCommunity = findViewById(R.id.bt_home_society)
        btCommunity.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("tabIndex", 0)
            startActivity(intent)
        }
        btChat = findViewById(R.id.bt_home_chat)
        btChat.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("tabIndex", 2)
            startActivity(intent)
        }
        btHome = findViewById(R.id.bt_home_home)
        btHome.setOnClickListener{
            Toast.makeText(this, "Już jesteś w Home", Toast.LENGTH_SHORT).show()
        }
    }


}