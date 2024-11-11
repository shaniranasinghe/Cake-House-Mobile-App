package com.example.myapplication

import android.net.Uri
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat

class VideoPreviewActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var btnPlay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_video_preview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }

        videoView = findViewById(R.id.videoView)
        btnPlay = findViewById(R.id.btnPlay)

        // Set the path of the video (local video in the raw folder)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.video1
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)

        // Play the video when the Play button is clicked
        btnPlay.setOnClickListener {
            videoView.start()
        }

        // Optional: Show controls (pause, forward, etc.)
        videoView.setMediaController(android.widget.MediaController(this))
    }
}
