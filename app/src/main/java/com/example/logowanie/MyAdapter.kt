package com.example.logowanie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.logowanie.entity.Article
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class MyAdapter (private var articles: List<Article>) : RecyclerView.Adapter<MyViewHolderArticle>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderArticle {
        val leyautInflater = LayoutInflater.from(parent.context)
        val contactRow = leyautInflater.inflate(R.layout.contact_row, parent, false)
        return MyViewHolderArticle(contactRow)
    }
    override fun onBindViewHolder(holder: MyViewHolderArticle, position: Int) {
        holder.bind(articles[position])
    }
    override fun getItemCount(): Int {
        return articles.size
    }
}

class MyViewHolderArticle (val view: View): RecyclerView.ViewHolder(view){

    var titleTextView : TextView = view.findViewById(R.id.titleTextView)
    var contentTextView : TextView = view.findViewById(R.id.contentTextView)
    var readMoreButton : Button = view.findViewById(R.id.readMoreButton)
    var image : RoundedImageView = view.findViewById(R.id.avatarImageView)


    fun bind(article: Article) {
        titleTextView.text = article.title
        contentTextView.text = article.content

        if (article.url != null) {
            var imageUrl: String = article.url
            Picasso.get().load(imageUrl).into(image)
        }

        readMoreButton.setOnClickListener {
            val intent = Intent(itemView.context, ArticleActivity::class.java)
            intent.putExtra("article_title", article.title)
            intent.putExtra("article_content", article.content)
            intent.putExtra("article_url", article.url)
            itemView.context.startActivity(intent)
        }
    }
}