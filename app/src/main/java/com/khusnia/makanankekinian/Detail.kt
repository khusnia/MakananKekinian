package com.khusnia.makanankekinian

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail.*
import java.net.URL

class Detail : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)
        var intentThatStartedThisActivity = intent
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_INTENT)) {
            showContent(intentThatStartedThisActivity)
        }
    }

    private fun showContent(intentThatStartedThisActivity: Intent){
        val nama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INTENT)
        val deskripsi = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
        val alamat = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
        val gambar = intentThatStartedThisActivity.getIntExtra(Intent.EXTRA_TEXT, 0)
        val web = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_ORIGINATING_URI)

        tv_name_detail.text = nama
        tv_desc_detail.text = deskripsi
        tv_short_detail.text = alamat
        logosby.contentDescription = nama
        logosby.setImageResource(gambar)


        if (web == "") {
            tv_link_web.text = ""
            website_detail.text = ""
        } else {
            tv_link_web.text = web
        }
        tv_link_web.setOnClickListener {
            clickWeb(web)
        }
    }
    private fun clickWeb (url: String?){
        val showWebActivity = Intent(this, Web::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        startActivity(showWebActivity)
    }
}