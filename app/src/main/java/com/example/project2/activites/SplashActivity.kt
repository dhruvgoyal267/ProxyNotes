package com.example.project2.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.R

class SplashActivity : AppCompatActivity() {

    val User = "User"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            {
                var checkUser =
                    getSharedPreferences(User, Context.MODE_PRIVATE)
                if (checkUser.getBoolean("User", true)) {
                    var editor =
                        getSharedPreferences(User, Context.MODE_PRIVATE)
                            ?.edit()
                    //means user already registered
                    editor?.putBoolean("User", false)
                    editor?.apply()
                    val intent = Intent(
                        this,
                        Instruction::class.java
                    )
                    startActivity(intent)
                    this.finish()
                } else {
                    val intent = Intent(
                        this,
                        MainActivity::class.java
                    )
                    startActivity(intent)
                    this.finish()
                }
            }, 1000

        )
    }
}
