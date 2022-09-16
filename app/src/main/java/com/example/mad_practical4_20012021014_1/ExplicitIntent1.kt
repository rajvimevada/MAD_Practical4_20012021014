package com.example.mad_practical4_20012021014_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ExplicitIntent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent1)

        val intent=intent
        val message = intent.getStringExtra("message_key")
        val messageTextView: TextView = findViewById(R.id.text)
        messageTextView.text = "Your message is: " + message
    }
}