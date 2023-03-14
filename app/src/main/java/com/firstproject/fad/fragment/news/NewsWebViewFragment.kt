package com.firstproject.fad.fragment.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.firstproject.fad.MainActivity
import com.firstproject.fad.R
import kotlinx.android.synthetic.main.fragment_webview.*

class NewsWebViewFragment : Fragment() {

    companion object {
        private const val ARG_URL = "url"
        private const val ARG_TITLE = "title"

        fun newInstance(url: String, title: String): NewsWebViewFragment {
            val args = Bundle().apply {
                putString(ARG_URL, url)
                putString(ARG_TITLE, title)
            }
            val fragment = NewsWebViewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        news_webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        val url = arguments?.getString(ARG_URL)
//        val title = arguments?.getString(ARG_TITLE)
        if (url != null) {
            news_webView.loadUrl(url)
//            selected_news_title.text = title
        } else {
            activity?.finish()
        }

//        activity?.onBackPressedDispatcher?.addCallback(
//            viewLifecycleOwner,
//            object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    if (news_webView.canGoBack()) {
//                        news_webView.goBack()
//                    } else {
//                        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
//                        val transaction = fragmentManager.beginTransaction()
//                        val fragment = NewsFragment()
//                        transaction.replace(R.id.container_main, fragment)
//                        transaction.commit()
//                        activity?.finish()
//                    }
//                }
//            })
        setNavigationAndroid()
    }

    private fun setNavigationAndroid() {
        toolbar_back_news.setNavigationOnClickListener {
            if (news_webView.canGoBack()) {
                news_webView.goBack()
            } else {
//                        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
//                        val transaction = fragmentManager.beginTransaction()
//                        val fragment = NewsFragment()
//                        transaction.replace(R.id.container_main, fragment)
//                        transaction.commit()
//                        activity?.finish()
            }
        }
    }
}