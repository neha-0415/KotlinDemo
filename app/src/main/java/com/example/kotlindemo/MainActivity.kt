package com.example.kotlindemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.btn3)
        var txt = findViewById<TextView>(R.id.txt1)

        var flag = false

        btn.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button

            if(flag) {
                txt.setText("Neha Dandime")
                flag=false
            }
            else {
                txt.setText("Hello World!!!")
                flag=true
            }
        })
    }
}