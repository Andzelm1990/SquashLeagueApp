package com.example.logowanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var btLogowanieNormal : Button? = null
    var btLogowanieFacebook : Button? = null
    var btLogowanieGoogle : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu()
    }




    fun menu(){
        btLogowanieNormal = findViewById(R.id.bt_login_normal)
        btLogowanieFacebook = findViewById(R.id.bt_login_facebook)
        btLogowanieGoogle = findViewById(R.id.bt_login_google)

        btLogowanieNormal?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        btLogowanieFacebook?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        btLogowanieGoogle?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}