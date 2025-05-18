package com.amaurypm.videoplayerswipe

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.videoplayerswipe.databinding.ItemVideoBinding
import com.amaurypm.videoplayerswipe.model.Video

class VideoViewHolder(
    private val binding: ItemVideoBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(video: Video){

        binding.apply {

            tvVideoTitle.text = video.title
            tvVideoDescription.text = video.description

            vvVideo.setVideoPath(video.url)

            vvVideo.setOnPreparedListener { mediaPlayer ->

                pbVideo.visibility = View.INVISIBLE

                mediaPlayer.start()

                val videoRatio: Float = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()

                val screenRatio: Float = vvVideo.width / vvVideo.height.toFloat()

                val scale: Float = videoRatio / screenRatio

                //Asegura que el video mantenga su relación de aspecto original sin distorsión
                //Lo adapta a la pantalla usando todo el espacio disponible
                if(scale >= 1f){ //El video es más ancho que la pantalla, se ajusta al eje x
                    vvVideo.scaleX = scale
                }else{ //El video es más alto que la pantalla, ajusto el eje y
                    vvVideo.scaleY = 1f/scale
                }

            }

            //Para que el video se reproduzca en un loop
            vvVideo.setOnCompletionListener { mediaPlayer ->
                mediaPlayer.start()
            }

        }

    }

}