package com.example.logowanie

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
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

    private lateinit var btRanking : ImageButton
    private lateinit var btMap : ImageButton
    private lateinit var btCommunity : ImageButton
    private lateinit var btChat : ImageButton
    private lateinit var btHome : ImageButton

    private lateinit var btwojsko : ImageButton
    private lateinit var btpolicja : ImageButton
    private lateinit var btdoktor : ImageButton
    private lateinit var btstraz : ImageButton

    private var mediaPlayerStraz: MediaPlayer? = null
    private var mediaPlayerPolicja: MediaPlayer? = null
    private var mediaPlayerDoktor: MediaPlayer? = null
    private var mediaPlayerWojsko: MediaPlayer? = null

    var firstTuch = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)



        val leftMenu : LeftMenu = LeftMenu(this)
        leftMenu.nawigationLeft()
        intent()

            buttonPolicjaClick()
            buttonDoktorClick()
            buttonStrazClick()
            buttonWojskoClick()




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
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }


    fun buttonStrazClick(){
        btstraz = findViewById(R.id.bt_strazak)
        mediaPlayerStraz = MediaPlayer.create(this, R.raw.strazaczek)
        btstraz.setOnClickListener{
            if (firstTuch == 0){
                btstraz.setImageResource(R.drawable.strazak)
                mediaPlayerStraz?.start()
                firstTuch = 1
            }
            else{
                mediaPlayerStraz?.stop()
                firstTuch = 0
            }
        }
    }



    fun buttonPolicjaClick(){
        btpolicja = findViewById(R.id.bt_policja)
        mediaPlayerPolicja = MediaPlayer.create(this, R.raw.policjant)
        btpolicja.setOnClickListener{
            if (firstTuch == 0) {
                btpolicja.setImageResource(R.drawable.policjant)
                mediaPlayerPolicja?.start()
            }else{
                mediaPlayerPolicja?.stop()
                firstTuch = 0
            }
        }
    }

    fun buttonDoktorClick(){
        btdoktor = findViewById(R.id.bt_doctor)
        mediaPlayerDoktor = MediaPlayer.create(this, R.raw.lekarz)
        btdoktor.setOnClickListener{
            if (firstTuch == 0) {
                btdoktor.setImageResource(R.drawable.doktor)
                mediaPlayerDoktor?.start()
                firstTuch = 1
            }else{
                mediaPlayerDoktor?.stop()
                firstTuch = 0
            }
        }
    }

    fun buttonWojskoClick(){
        btwojsko = findViewById(R.id.bt_wojsko)
        mediaPlayerWojsko = MediaPlayer.create(this, R.raw.wojskowy)
        btwojsko.setOnClickListener{
            if (firstTuch == 0) {
                btwojsko.setImageResource(R.drawable.wojsko)
                mediaPlayerWojsko?.start()
                firstTuch = 1
            }else{
                mediaPlayerWojsko?.stop()
                firstTuch = 0
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerStraz?.release()
        mediaPlayerPolicja?.release()
        mediaPlayerDoktor?.release()
        mediaPlayerWojsko?.release()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayerStraz?.pause()
        mediaPlayerPolicja?.pause()
        mediaPlayerDoktor?.pause()
        mediaPlayerWojsko?.pause()
    }
            }
