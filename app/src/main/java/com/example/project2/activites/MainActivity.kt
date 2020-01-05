package com.example.project2.activites

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

import com.example.project2.R
import com.example.project2.supportLibrary.OnSwipeTouchListener
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var videoPlayer: VideoView
    private var rand: Int = 0
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoPlayer = this.findViewById(R.id.videoPlayer)
        videoSelector(-1)
        videoPlayer.setOnTouchListener(
            object : OnSwipeTouchListener(this) {
                override fun onSwipeLeft() {
                    super.onSwipeLeft()
                    val builder = AlertDialog.Builder(this@MainActivity)
                    val inflater = layoutInflater
                    builder.setCancelable(false)
                    val layout = inflater.inflate(R.layout.subscribed, null)
                    builder.setView(layout)
                    val alertDialog = builder.create()
                    alertDialog?.show()
                    Handler().postDelayed(
                        {
                            alertDialog?.dismiss()
                        }, 2000
                    )
                }

                override fun onSwipeRight() {
                    super.onSwipeRight()
                    val intent = Intent(
                        this@MainActivity,
                        UserProfile::class.java
                    )
                    intent.putExtra("id", rand)
                    startActivity(intent)
                }

                override fun onSwipeTop() {
                    super.onSwipeTop()
                    videoSelector((rand + 1) % 4)
                }

                override fun onSwipeBottom() {
                    super.onSwipeBottom()
                    videoSelector(rand - 1)
                }
            }
        )
    }

    fun videoSelector(num: Int) {
        videoPlayer.stopPlayback()
        rand = if (num == -1) {
            Random.nextInt(5)
        } else
            num
        var path = ""
        when (rand) {
            0 -> {
                path = "android.resource://${packageName}/${R.raw.video_one}"
            }
            1 -> {
                path = "android.resource://${packageName}/${R.raw.video_two}"
            }
            2 -> {
                path = "android.resource://${packageName}/${R.raw.video_three}"
            }
            3 -> {
                path = "android.resource://${packageName}/${R.raw.video_four}"
            }
            4 -> {
                path = "android.resource://${packageName}/${R.raw.video_five}"
            }
        }
        val uri = Uri.parse(path)
        videoPlayer.setVideoURI(uri)
        videoPlayer.start()
        videoPlayer.setOnCompletionListener {
            videoSelector((rand + 1) % 4)
        }
    }

    override fun onResume() {
        super.onResume()
        videoSelector(rand)
    }
}
