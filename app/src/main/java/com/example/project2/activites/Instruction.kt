package com.example.project2.activites

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.R

class Instruction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction)

        val swipeUp: RelativeLayout = findViewById(R.id.swipeUp)
        val swipeDown: RelativeLayout = findViewById(R.id.swipeDown)
        val swipeLeft: RelativeLayout = findViewById(R.id.swipeLeft)
        val swipeRight: RelativeLayout = findViewById(R.id.swipeRight)

        Handler().postDelayed(
            {
                swipeUp.visibility = View.GONE
                swipeDown.visibility = View.VISIBLE
            }, 2000
        )
        Handler().postDelayed(
            {
                swipeDown.visibility = View.GONE
                swipeLeft.visibility = View.VISIBLE
            }, 4000
        )
        Handler().postDelayed(
            {
                swipeLeft.visibility = View.GONE
                swipeRight.visibility = View.VISIBLE
            }, 6000
        )
        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()
            }, 8000
        )
    }
}
