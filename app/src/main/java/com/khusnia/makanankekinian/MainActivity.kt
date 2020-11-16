package com.khusnia.makanankekinian

import android.content.Intent
import android.content.Intent.EXTRA_ORIGINATING_URI
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = BuatMakanan()
        rv_list_main.layoutManager = LinearLayoutManager(this)
        rv_list_main.setHasFixedSize(true)
        rv_list_main.adapter = Adapter(data, { onItem: Data -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            onItemClicked(onItem)
        }
        })
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun onItemClicked(onItem: Data) {
        val showDetailActivityIntent = Intent(this, Detail::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INTENT, onItem.nama)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, onItem.deskripsi)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, onItem.alamat)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, onItem.gambar)
        showDetailActivityIntent.putExtra(EXTRA_ORIGINATING_URI, onItem.web)
        startActivity(showDetailActivityIntent)
    }

}