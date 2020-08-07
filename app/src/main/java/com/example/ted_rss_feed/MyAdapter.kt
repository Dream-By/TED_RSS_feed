package com.example.ted_rss_feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val items: List<Item>): RecyclerView.Adapter<ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        return ItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
        System.out.println("items.size - " + items.size)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val title = items[position].title ?: ""

        val imageurl = items[position].image.url ?: ""
        holder.bind(title, imageurl)
    }
}


class ItemsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo: ImageView = itemView.findViewById(R.id.image_photo)
    private val title_text: TextView = itemView.findViewById(R.id.title_)
    private val description_text:TextView = itemView.findViewById(R.id.description)


    fun bind(title: String,imageurl:String) {
        Glide.with(itemView.context).load(imageurl).into(photo)
        title_text.text = title.substringAfter('|').drop(1)
        description_text.text = title.substringBefore('|').dropLast(1)
    }

}