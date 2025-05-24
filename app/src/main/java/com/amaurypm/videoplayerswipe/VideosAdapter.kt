package com.amaurypm.videoplayerswipe

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videoplayerswipe.databinding.ItemVideoBinding
import com.amaurypm.videoplayerswipe.model.Video

class VideosAdapter(
    private val videos: List<Video>
): RecyclerView.Adapter<VideoViewHolder>() {

    var isFav = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: VideoViewHolder,
        position: Int
    ) {
        holder.bind(videos[position])

        //Click al elemento de favorito
        holder.ic_fav.setOnClickListener {
            isFav = !isFav
            val color = if(isFav) Color.RED else Color.WHITE
            holder.ic_fav.setColorFilter(color)
        }
    }

    override fun getItemCount(): Int = videos.size


}