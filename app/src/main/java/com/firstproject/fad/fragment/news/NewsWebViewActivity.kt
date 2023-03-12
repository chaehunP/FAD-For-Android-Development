package com.firstproject.fad.fragment.news

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.activity_webview.*


class NewsWebViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)


        news_webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        val url = intent.dataString
        if (url != null) {
            news_webView.loadUrl(url)
        } else {
            finish()
        }

    }
}