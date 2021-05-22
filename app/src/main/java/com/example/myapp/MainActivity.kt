package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.btn)
        var txt = findViewById<TextView>(R.id.txt)
        var input_radius = findViewById<EditText>(R.id.input_radius)


        btn.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            var radius= input_radius.text.toString().toDouble()
            val pi = 3.1415
            var area = radius * radius * pi
            txt.text = "Area of Circle is $area"


        })
    }
}