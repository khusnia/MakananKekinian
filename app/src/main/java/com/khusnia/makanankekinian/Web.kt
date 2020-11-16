package com.khusnia.makanankekinian

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Web : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.web)

        val webView = findViewById<WebView>(R.id.web_view)

        val intentFromFaC = intent

        if (intentFromFaC.hasExtra(Intent.ACTION_VIEW)){

            val partWeb = intentFromFaC.getStringExtra(Intent.ACTION_VIEW)
            webView.settings.javaScriptEnabled = true

            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:alert('Website Berhasil Dimuat')")
                }
            }

            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: JsResult
                ): Boolean {
                    Toast.makeText(this@Web, message, Toast.LENGTH_SHORT).show()
                    result.confirm()
                    return true
                }
            }
            if (partWeb != null) {
                webView.loadUrl(partWeb)
            }
        }
    }
}