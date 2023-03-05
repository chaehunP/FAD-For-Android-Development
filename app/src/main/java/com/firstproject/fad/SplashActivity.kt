package com.firstproject.fad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        handler.postDelayed(runnable, 3000)

        splash_main.setOnClickListener{
            handler.removeCallbacks(runnable) // 화면을 클릭하고 메인화면으로 진입했을 때 다시 3초가 지나서 splash 화면이 안뜨도록 handler 중지
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val span: Spannable = tv_splash_title.text as Spannable

        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_violet)),12,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_blue)),11,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_green)),10,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_yellow)),8,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_orange)),7,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_red)),6,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_blue)),4,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_green)),3,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_yellow)),2,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_orange)),1,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(getColor(R.color.pastel_red)),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    }
}
