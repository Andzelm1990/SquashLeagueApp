package com.example.logowanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class ArticleActivity : AppCompatActivity() {
    var title: String? = null
    var content: String? = null
    var url: String? = null

    var titleTextView : TextView? = null
    var contentTextView : TextView? = null
    var image : ImageView? = null

    var ivExit : ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        title = intent.getStringExtra("article_title")
        content = intent.getStringExtra("article_content")
        url = intent.getStringExtra("article_url")

        titleTextView = findViewById(R.id.textView11)
        titleTextView?.text = title

        contentTextView = findViewById(R.id.textView12)
        contentTextView?.text = content

        image = findViewById(R.id.imageView3)


        if (url != null) {
            Picasso.get().load(url).into(image)
        }

        ivExit = findViewById(R.id.iv_exit)
        ivExit?.setOnClickListener {
            finish()
        }


    }
}