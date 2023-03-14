package com.firstproject.fad.fragment.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.*
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.coroutines.CoroutineContext


class NewsFragment : Fragment(), CoroutineScope {
    data class newsItem(val title: String, val link: String, val date: String)

    // 구글 뉴스의 RSS 피드를 가져오는 코드
    class RssFeed {
        private val url = "https://news.google.com/rss/search?q=IT&hl=ko&gl=KR&ceid=KR:ko"
        private val documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()


        suspend fun getNews(): List<newsItem> = withContext(Dispatchers.IO) {
            val rssUrl = URL(url)
            val connection = rssUrl.openConnection()
            val inputStream = connection.getInputStream()
            val document = documentBuilder.parse(inputStream)
            val newsList = mutableListOf<newsItem>()
            val nodeList = document.getElementsByTagName("item")
            for (i in 0 until nodeList.length) {
                val node = nodeList.item(i)
                if (node.nodeType == org.w3c.dom.Node.ELEMENT_NODE) {
                    val element = node as org.w3c.dom.Element
                    val title = element.getElementsByTagName("title").item(0).textContent
//                    val imageUrl = element.getElementsByTagName("media:content")
//                        .item(0)?.attributes?.getNamedItem("url")?.textContent ?: ""
                    val link = element.getElementsByTagName("link").item(0).textContent
                    val date = element.getElementsByTagName("pubDate").item(0).textContent
//                    val description = element.getElementsByTagName("description").item(0).textContent
                    val news = newsItem(title, link, date)
                    newsList.add(news)
                }
            }
            newsList
        }
    }

    // 코틀린에서 코루틴을 사용할 때, 코루틴의 작업을 관리하는 Job 객체를 생성하고, 그 Job 객체를 사용하는 방법을 보여주는 코드
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 가져온 RSS 피드를 화면에 뉴스 정보를 출력하는 기능을 수행하는 코드
        GlobalScope.launch(Dispatchers.Main) {
            val newsList = RssFeed().getNews()
            val newsString = StringBuilder()
            newsList.forEach {
                newsString.append(it.title)
                newsString.append("\n")
                newsString.append(it.date)
                newsString.append("\n\n")
            }
            try {
                rv_news.adapter = NewsAdapter(context, newsList)
            } catch (e: IllegalStateException) {
                // 어댑터가 연결되어 있지 않은 상태에서 데이터를 추가하려고 하면 예외가 발생할 수 있음
                // 예외 처리를 해줌으로써 앱이 종료되는 것을 방지할 수 있음
                e.printStackTrace()
            }
        }
    }
}