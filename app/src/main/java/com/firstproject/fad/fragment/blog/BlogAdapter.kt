package com.firstproject.fad.fragment.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.item_blog.view.*

data class data(val title: String, val name: String, val time: String)

class BlogAdapter: RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    val dataList = arrayListOf(
        data("안드로이드 기초 개발 블로그", "박채훈", "6시간 전"),
        data("안드로이드 스튜디오 설치 과정", "박채훈", "8시간 전"),
        data("안드로이드 매니페스트", "박채훈", "10시간 전"),
        data("안드로이드 Button", "박채훈", "14시간 전"),
        data("안드로이드 TextView 속성", "박채훈", "16시간 전"),
        data("안드로이드 ConstraintLayout", "박채훈", "18시간 전"),
        data("안드로이드 RecyclerView", "박채훈", "20시간 전"),
        data("안드로이드 스튜디오 웹 크롤링", "박채훈", "22시간 전"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val blogRecyclerView = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(blogRecyclerView)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.blogTitle.setText(dataList[position].title)
        holder.blogAuthor.setText(dataList[position].name)
        holder.blogTime.setText(dataList[position].time)
    }

    class BlogViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val blogTitle = v.tv_blog_title
        val blogAuthor = v.tv_author
        val blogTime = v.tv_time
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}