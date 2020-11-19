package com.example.texts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var refUsers : DatabaseReference
    private var firebaseuserID : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_register)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Register"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this@RegisterActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        mAuth = FirebaseAuth.getInstance()
        register_button.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser(){
        val username: String = username_register.text.toString()
        val email: String = email_register.text.toString()
        val password: String = password_register.text.toString()
        if (username == "") {
            Toast.makeText(this@RegisterActivity, "Please enter username", Toast.LENGTH_LONG).show()
        } else if (email == "") {
            Toast.makeText(this@RegisterActivity, "Please enter email", Toast.LENGTH_LONG).show()
        } else if (password == "") {
            Toast.makeText(this@RegisterActivity, "Please enter password", Toast.LENGTH_LONG).show()
        } else {
            mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        firebaseuserID = mAuth.currentUser!!.uid
                        refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseuserID)
                        val userHashMap = HashMap<String, Any>()
                        userHashMap["uid"] = firebaseuserID
                        userHashMap["username"] = username
                        userHashMap["profile"] = "https://firebasestorage.googleapis.com/v0/b/texts-d060a.appspot.com/o/profile.png?alt=media&token=1a429182-ed26-46d7-a16c-6ede63e1ba6d"
                        userHashMap["status"] = "offline"
                        userHashMap["search"] = username.toLowerCase()

                        refUsers.updateChildren(userHashMap)
                            .addOnCompleteListener { task ->
                                if(task.isSuccessful) {
                                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                    } else {
                        Toast.makeText(this@RegisterActivity, "Unable to save the user to database: " + task.exception!!.message, Toast.LENGTH_LONG).show()
                    }

                }
        }
    }
}