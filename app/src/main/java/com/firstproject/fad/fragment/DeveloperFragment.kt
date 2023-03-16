package com.firstproject.fad.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.firstproject.fad.MainActivity
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.fragment_developer.*

class DeveloperFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_developer, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        android_webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }

        android_webView.loadUrl("https://developer.android.com/?hl=ko")

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (android_webView.canGoBack()) {
                        android_webView.goBack()
                    } else {
                        startActivity(Intent(context, MainActivity::class.java))
                        activity?.finish()
                    }
                }
            })

        setNavigationAndroid()
    }

    private fun setNavigationAndroid() {
        toolbar_back_android.setNavigationOnClickListener {
            if (android_webView.canGoBack()) {
                android_webView.goBack()
            } else {
                startActivity(Intent(context, MainActivity::class.java))
                activity?.finish()
            }
        }
    }
}