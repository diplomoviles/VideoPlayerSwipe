package com.amaurypm.videoplayerswipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videoplayerswipe.databinding.ItemVideoBinding
import com.amaurypm.videoplayerswipe.model.Video

/**
 * Creado por Amaury Perea Matsumura el 14/01/23
 */

class VideosAdapter(private val context: Context, val videos: ArrayList<Video>): RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    class ViewHolder(view: ItemVideoBinding): RecyclerView.ViewHolder(view.root) {
        private val vvVideo = view.vvVideo
        private val tvVideoTitle = view.tvVideoTitle
        private val tvVideoDescription = view.tvVideoDescription
        private val pbVideo = view.pbVideo

        fun setVideoData(video: Video){
            tvVideoTitle.text = video.title
            tvVideoDescription.text = video.description
            vvVideo.setVideoPath(video.url)

            vvVideo.setOnPreparedListener { mediaplayer ->
                pbVideo.visibility = View.GONE
                mediaplayer.start()

                val videoRatio: Float = mediaplayer.videoWidth / mediaplayer.videoHeight.toFloat()
                val screenRatio: Float = vvVideo.width / vvVideo.height.toFloat()

                val scale: Float = videoRatio / screenRatio

                if(scale >= 1f){
                    vvVideo.scaleX = scale
                }else{
                    vvVideo.scaleY = 1f / scale
                }
            }

            vvVideo.setOnCompletionListener { mediaplayer ->
                mediaplayer.start()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setVideoData(videos[position])
    }

    override fun getItemCount(): Int = videos.size
}