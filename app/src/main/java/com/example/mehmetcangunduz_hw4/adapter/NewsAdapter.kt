package com.example.mehmetcangunduz_hw4.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mehmetcangunduz_hw4.R
import com.example.mehmetcangunduz_hw4.models.News

class NewsAdapter(private val context: Activity, private val list:List<News>) : ArrayAdapter<News>(context,
    R.layout.custom_list_item,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.custom_list_item, null, true)
        val img_haber = rootView.findViewById<ImageView>(R.id.img_haber)
        val txt_baslik = rootView.findViewById<TextView>(R.id.txt_baslik)


        val value = list.get(position)

        txt_baslik.text = value.title

        Glide
            .with(rootView)
            .load(value.img)
            .into(img_haber)

        return rootView
    }
}
