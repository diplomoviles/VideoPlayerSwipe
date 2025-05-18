package com.amaurypm.videoplayerswipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videoplayerswipe.databinding.ItemVideoBinding
import com.amaurypm.videoplayerswipe.model.Video

class VideosAdapter(
    private val videos: List<Video>
): RecyclerView.Adapter<VideoViewHolder>() {
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
    }

    override fun getItemCount(): Int = videos.size


}