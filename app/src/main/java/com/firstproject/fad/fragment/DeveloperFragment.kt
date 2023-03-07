package com.firstproject.fad.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.firstproject.fad.MainActivity
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.fragment_developer.*
import kotlinx.android.synthetic.main.fragment_developer.view.*

class DeveloperFragment : Fragment(), View.OnClickListener {
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

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (android_webView.canGoBack()) {
                        android_webView.goBack()
                    } else {
//                    System.exit(0)
                        startActivity(Intent(context, MainActivity::class.java))
                        activity?.finish()
                    }
                }
            })
    }

    override fun onClick(v: View?) {
        v?.iv_back?.setOnClickListener {
            activity?.onBackPressedDispatcher?.addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        if (android_webView.canGoBack()) {
                            android_webView.goBack()
                        } else {
                        }
                    }
                })
        }
    }
}