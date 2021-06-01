package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var btn = findViewById<Button>(R.id.button2)
        var input = findViewById<EditText>(R.id.text1)
        var result = findViewById<TextView>(R.id.textView2)

        btn.setOnClickListener(View.OnClickListener {

            var range = input.text.toString().toInt();
            var i:Int = 1
            var s:String = ""
            while(true)
            {
                if(i>range)
                {
                    break;
                }
                s = s + "@$i";
                i = i+1
            }
            result.setText(s)
        })
    }
}