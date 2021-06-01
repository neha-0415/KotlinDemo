package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

fun add(a:Double , b:Double):Double {
    return a+b
}

fun sub(a:Double , b:Double):Double {
    return a-b
}

fun multiply(a:Double , b:Double):Double{
    return a*b
}

fun divide(a:Double ,b:Double):Double {
    return a/b
}

fun remainder(a:Double , b:Double):Double{
    return a%b
}



class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var btn = findViewById<Button>(R.id.btn_3)
        var op1 = findViewById<EditText>(R.id.op1)
        var op2 = findViewById<EditText>(R.id.op2)
        var txt = findViewById<TextView>(R.id.txt_3)
        var spin = findViewById<Spinner>(R.id.spinner2)

        btn.setOnClickListener(View.OnClickListener {

            var operand:String = spin.selectedItem.toString()
            var num1 = op1.text.toString().toDouble()
            var num2 = op2.text.toString().toDouble()
            when(operand)
            {
                "+"-> txt.text ="Sum is ${add(num1,num2)}"
                "-"-> txt.text ="Difference is ${sub(num1,num2)}";
                "*"-> txt.text ="Product is ${multiply(num1,num2)}"
                "/"-> txt.text ="Quotient is ${divide(num1,num2)}"
                "%"-> txt.text ="Remainder is ${remainder(num1,num2)}";
            }
        })
    }
}