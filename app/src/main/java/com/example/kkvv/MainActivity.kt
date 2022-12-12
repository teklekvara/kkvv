package com.example.kkvv

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var passwordRegistration : EditText
    private lateinit var emailRegistration : EditText
    private lateinit var buttonRegistration : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordRegistration = findViewById(R.id.passwordRegistration)
        emailRegistration = findViewById(R.id.emailRegistration)
        buttonRegistration = findViewById(R.id.buttonRegistration)



        buttonRegistration.setOnClickListener {


            val email = emailRegistration.text.toString()
            val password = passwordRegistration.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "იმეილის/პაროლის ველი ცარიელია!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "რეგისტრაცია დასრულებულია", Toast.LENGTH_SHORT)
                            .show()

                    } else {
                        Toast.makeText(this, "შეცდომაა", Toast.LENGTH_SHORT).show()
                    }


                }


        }

    }



}