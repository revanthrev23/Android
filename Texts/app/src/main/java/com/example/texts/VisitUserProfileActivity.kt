package com.example.texts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.texts.ModelClasses.Users
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_visit_user_profile.*

class VisitUserProfileActivity : AppCompatActivity() {

    private var userVisitId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit_user_profile)

        userVisitId = intent.getStringExtra("visit_id")!!
        val ref = FirebaseDatabase.getInstance().reference.child("Users").child(userVisitId)
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    val user = p0.getValue(Users::class.java)
                    user_name_display.text = user!!.getUsername()
                    Picasso.get().load(user.getProfile()).into(profile_display)

                    send_msg.setOnClickListener {
                        val intent = Intent(this@VisitUserProfileActivity, MessageChatActivity::class.java)
                        intent.putExtra("visit_id", user.getUid())
                        startActivity(intent)
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}