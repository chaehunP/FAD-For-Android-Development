package com.firstproject.fad.fragment.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.item_news.view.*

data class data(val title: String, val newsImage: Int, val time: String)

class BlogAdapter: RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    val dataList = arrayListOf(
        data("프로그래밍이란 무엇인가 정말 궁금하지 않니?", R.drawable.ic_baseline_android_24, "2023-03-08"),
        data("chatGPT 활용법 무궁무진..", R.drawable.ic_baseline_home_24, "2023-03-06"),
        data("안드로이드 개발자 취업준비...", R.drawable.ic_baseline_code_24, "2023-03-3"),
        data("IT 뉴스 헤드라인 입니다.", R.drawable.ic_baseline_web_24, "2023-03-01"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val blogRecyclerView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return BlogViewHolder(blogRecyclerView)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.newsTitle.setText(dataList[position].title)
        holder.newsImage.setImageResource(dataList[position].newsImage)
        holder.newsTime.setText(dataList[position].time)
    }

    class BlogViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val newsTitle = v.tv_news_title
        val newsImage = v.iv_news_thumbnail
        val newsTime = v.tv_date
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}