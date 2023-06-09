package com.example.mehmetcangunduz_hw4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import com.example.mehmetcangunduz_hw4.adapter.NewsAdapter
import com.example.mehmetcangunduz_hw4.services.Result

class MainActivity : AppCompatActivity() {
    lateinit var listView_haber : ListView
    val resultService = Result()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView_haber = findViewById(R.id.listView_haber)


        val run = Runnable{

            val list = resultService.news()
            Log.d("title",list.get(0).href)
            val customAdapter = NewsAdapter(this,list)
            runOnUiThread {
                listView_haber.adapter = customAdapter
                listView_haber.onItemClickListener =
                    AdapterView.OnItemClickListener { adapterView, view, i, l ->

                        val intent = Intent(applicationContext, Detail::class.java)
                        intent.putExtra("haber", list[i].href)
                        startActivity(intent)

                    }
            }
        }

        Thread(run).start()


    }
}