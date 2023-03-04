package com.firstproject.fad

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_developer.*
import kotlinx.android.synthetic.main.fragment_kotlin.*

class KotlinFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kotlin_webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        kotlin_webView.loadUrl("https://kotlinlang.org/docs/basic-syntax.html")

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (kotlin_webView.canGoBack()) {
                    kotlin_webView.goBack()
                } else {
//                    System.exit(0)
                }
            }
        })
    }
}