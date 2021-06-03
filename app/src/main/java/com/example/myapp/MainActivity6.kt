package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        var name =findViewById<EditText>(R.id.name)
        var gender = findViewById<EditText>(R.id.gender)
        var age = findViewById<EditText>(R.id.age)
        var btn =findViewById<Button>(R.id.button4)


        btn.setOnClickListener(View.OnClickListener {

            val person =Person()
            person.name = name.text.toString()
            person.gender = gender.text.toString()
            person.age = age.text.toString().toInt()

            var result = if(person.age!=0) "${person.name}" else print("Person is Minor")

            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()

        })
    }
}