package com.example.mehmetcangunduz_hw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Detail : AppCompatActivity() {
    lateinit var webView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        webView = findViewById(R.id.webView)
        val url = intent.getStringExtra("haber");
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url!!)
    }
}