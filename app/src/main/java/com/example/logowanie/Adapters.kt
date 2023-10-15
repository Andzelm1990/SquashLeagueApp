package com.example.logowanie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.logowanie.entity.Article
import com.example.logowanie.fragment.*
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



class MyViewHolder (val view: View): RecyclerView.ViewHolder(view)

class MyAdapterRanking : RecyclerView.Adapter<MyViewHolderRanking>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderRanking {
        val leyautInflater = LayoutInflater.from(parent.context)
        val tabelRow = leyautInflater.inflate(R.layout.tabel_row, parent, false)
        return MyViewHolderRanking(tabelRow)
    }

    override fun onBindViewHolder(holder: MyViewHolderRanking, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }
}

class MyViewHolderRanking (val view: View): RecyclerView.ViewHolder(view)

class ViewPagerAdapter(fragment: Ranking) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentRankingTable()
            1 -> SearchForLeagues()
            2 -> SearchForLeagues()
            3 -> FragmentMyMatch()

            else -> FragmentRankingTable()
        }
    }
}

class AdapterLigues : RecyclerView.Adapter<MyViewHolderRanking>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderRanking {
        val leyautInflater = LayoutInflater.from(parent.context)
        val tabelRow = leyautInflater.inflate(R.layout.row_liga, parent, false)
        return MyViewHolderRanking(tabelRow)
    }

    override fun onBindViewHolder(holder: MyViewHolderRanking, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}

class AdapterPlayers : RecyclerView.Adapter<MyViewHolderRanking>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderRanking {
        val leyautInflater = LayoutInflater.from(parent.context)
        val tabelRow = leyautInflater.inflate(R.layout.row_player, parent, false)
        return MyViewHolderRanking(tabelRow)
    }
    override fun onBindViewHolder(holder: MyViewHolderRanking, position: Int) {

    }
    override fun getItemCount(): Int {
        return 10
    }
}

class ViewPagerAdapterCommunity(fragment: CommunityActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SearchForPlayers()
            1 -> SearchForPlayers()
            2 -> SearchForPlayers()
            else -> FragmentRankingTable()
        }
    }
}