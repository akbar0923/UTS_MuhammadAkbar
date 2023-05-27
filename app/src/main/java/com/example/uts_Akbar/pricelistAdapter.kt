package com.example.uts_Akbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class pricelistAdapter (private val context: Context, private val music: List<pricelist>, val listener: (pricelist) -> Unit)
    : RecyclerView.Adapter<pricelistAdapter.AnimeViewHolder>(){
    class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgmusic = view.findViewById<ImageView>(R.id.img_item_photo)
        val namemusic = view.findViewById<TextView>(R.id.tv_item_name)
        val descmusic = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(music: pricelist, listener: (pricelist) -> Unit){
            imgmusic.setImageResource(music.imgpricelist)
            namemusic.text = music.namepricelist
            descmusic.text = music.descpricelist
            itemView.setOnClickListener{
                (listener(music))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_pricelist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindView(music[position], listener)
    }

    override fun getItemCount(): Int = music.size

}
