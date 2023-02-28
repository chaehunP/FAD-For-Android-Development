package com.firstproject.fad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_developer.*

class DeveloperFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_developer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        android_webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        android_webView.loadUrl("https://developer.android.com/?hl=ko")
    }

    fun onBackPressed() {
        if (android_webView.canGoBack())
        {
            android_webView.goBack()
        }
        else
        {
//            finish()
        }
    }

}