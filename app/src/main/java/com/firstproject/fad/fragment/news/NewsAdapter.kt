package com.firstproject.fad.fragment.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter(
    private val context: Context?,
    private val newsList: List<NewsFragment.newsItem>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val newsRecyclerView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(newsRecyclerView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem)
    }

    inner class NewsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val newsTitle = v.tv_news_title
        val newsDate = v.tv_date
        val newsCard = v.newsCard

        fun bind(news: NewsFragment.newsItem) {
            newsTitle.text = news.title
            newsDate.text = news.date
            newsCard.setOnClickListener {
                val position = adapterPosition
                val url = newsList[position].link
//                val intent = Intent(context, NewsWebViewActivity::class.java).apply {
//                    data = Uri.parse(url)
//                    putExtra("title", newsList[position].title)
//                }
//                context!!.startActivity(intent)

                val fragment = NewsWebViewFragment.newInstance(url, newsList[position].title)
                val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container_main, fragment)
                transaction.addToBackStack(null)
                transaction.commit()


            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}