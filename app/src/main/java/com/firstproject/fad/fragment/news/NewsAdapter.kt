package com.firstproject.fad.fragment.news

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter(
    private val context: Context?,
    private val newsList: List<NewsFragment.newsItem>
) : RecyclerView.Adapter<NewsAdapter.BlogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val blogRecyclerView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return BlogViewHolder(blogRecyclerView)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem)
    }

    inner class BlogViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val newsTitle = v.tv_news_title
        val newsDate = v.tv_date
        val newsCard = v.newsCard

        fun bind(news: NewsFragment.newsItem) {
            newsTitle.text = news.title
            newsDate.text = news.date
            newsCard.setOnClickListener {
                val position = adapterPosition
                val url = newsList[position].link
                val intent = Intent(context, NewsWebViewActivity::class.java).apply {
                    data = Uri.parse(url)
                }
                context!!.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}