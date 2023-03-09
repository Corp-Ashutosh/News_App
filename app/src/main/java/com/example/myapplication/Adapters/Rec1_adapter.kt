package com.example.myapplication.Adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.example.myapplication.R
import com.example.myapplication.Second_screen
import com.example.myapplication.model.Headlines

class Rec1_adapter(private val context: Context, private val items: List<Headlines>) : RecyclerView.Adapter<Rec1_adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.img_1)
        val title: TextView = view.findViewById(R.id.title)
        val author: TextView = view.findViewById(R.id.author)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(context)
            .load(item.urlToImage)
            .into(holder.image)
        holder.title.text = item.title
        holder.author.text= item.author
        holder.date.text = item.publishedAt.subSequence(0,10)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, Second_screen::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("author", item.author)
            intent.putExtra("date", item.publishedAt)
            intent.putExtra("content", item.content)
            intent.putExtra("urlToImage", item.urlToImage)
            intent.putExtra("url", item.url)

            context.startActivity(intent)}

        }





    override fun getItemCount(): Int {
        return items.size
    }

}









