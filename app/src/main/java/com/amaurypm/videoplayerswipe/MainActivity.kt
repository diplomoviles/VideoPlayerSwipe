package com.amaurypm.videoplayerswipe

import android.media.MediaRecorder.VideoSource
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amaurypm.videoplayerswipe.databinding.ActivityMainBinding
import com.amaurypm.videoplayerswipe.model.Video

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videos = ArrayList<Video>()

        var video1 = Video(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "Big Buck Bunny",
            "Este corto cuenta la historia de un conejo gigante con un corazón más grande que él mismo."
        )
        videos.add(video1)

        var video2 = Video(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            "Elephant Dream",
            "La primera película hecha en Blender en 2006"
        )
        videos.add(video2)

        var video3 = Video(
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
            "We Are Going On Bullrun",
            "Rally en un Shelby GT500 del 2011"
        )
        videos.add(video3)

        val adapter = VideosAdapter(this, videos)
        binding.vpVideos.adapter = adapter
    }
}