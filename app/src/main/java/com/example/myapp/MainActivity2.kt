
package com.example.myapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var layout = findViewById<ConstraintLayout>(R.id.container)
        var spinner = findViewById<Spinner>(R.id.spinner)
        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener(View.OnClickListener {
            var color: String = spinner.selectedItem.toString()
            when (color) {
                "Red" -> layout.setBackgroundColor(Color.RED)
                "Green" -> layout.setBackgroundColor(Color.GREEN)
                "Yellow" -> layout.setBackgroundColor(Color.YELLOW)
                "Green" -> layout.setBackgroundColor(Color.BLUE)
                "Gray" -> layout.setBackgroundColor(Color.GRAY)

            }
        })

    }
}