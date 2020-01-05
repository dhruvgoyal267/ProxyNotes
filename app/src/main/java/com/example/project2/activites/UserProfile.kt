package com.example.project2.activites

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.R
import de.hdodenhof.circleimageview.CircleImageView

class UserProfile : AppCompatActivity() {
    lateinit var userImage: CircleImageView
    lateinit var userName: TextView
    lateinit var contactNo: TextView
    lateinit var email: TextView
    var _id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        _id = intent.extras.getInt("id")

        userImage = findViewById(R.id.profile_image)
        userName = findViewById(R.id.userName)
        contactNo = findViewById(R.id.contactNo)
        email = findViewById(R.id.email)

        when (_id) {
            0 -> {
                userImage.setImageResource(R.drawable.user_one)
                userName.text = "Harry"
                contactNo.text = "+917548596147"
                email.text = "harry.12@gmail.com"
            }
            1 -> {

                userImage.setImageResource(R.drawable.user_two)
                userName.text = "Jack"
                contactNo.text = "+917854225456"
                email.text = "jack.78@gmail.com"
            }
            2 -> {
                userImage.setImageResource(R.drawable.user_three)
                userName.text = "Ram"
                contactNo.text = "+918855454785"
                email.text = "ram.969@gmail.com"
            }
            3 -> {
                userImage.setImageResource(R.drawable.user_four)
                userName.text = "Marry"
                contactNo.text = "+918855457546"
                email.text = "marry@gmail.com"
            }
            4 -> {
                userImage.setImageResource(R.drawable.user_five)
                userName.text = "Ruby"
                contactNo.text = "+919958467854"
                email.text = "ruby.78@gmail.com"
            }
        }
    }


}
