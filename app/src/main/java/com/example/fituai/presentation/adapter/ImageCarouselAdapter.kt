package com.example.fituai.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fituai.R
import androidx.core.content.ContextCompat

data class BannerItem(
    val imageRes: Int,
    val title: String
)

class ImageCarouselAdapter(
    private val items: List<BannerItem>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ImageCarouselAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewBanner)
        val titleView: TextView = view.findViewById(R.id.tvBannerTitle)
        val titleContainer: View = view.findViewById(R.id.titleContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageRes)
        holder.titleView.text = item.title

        // Cores do app em ciclo iniciando por laranja: laranja, roxo, amarelo
        val colorCycle = listOf(R.color.orange, R.color.purple, R.color.yellow)
        val colorRes = colorCycle[position % colorCycle.size]
        val colorInt = ContextCompat.getColor(holder.itemView.context, colorRes)
        holder.titleContainer.setBackgroundColor(colorInt)

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int = items.size
}
