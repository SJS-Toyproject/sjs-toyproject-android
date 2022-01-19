package com.cookandroid.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val go_sign_page = findViewById<Button>(R.id.go_sign_page) as Button

        go_sign_page.setOnClickListener {
            val intent = Intent(this, sign_Activity::class.java)
            startActivity(intent)

        }






    }



}