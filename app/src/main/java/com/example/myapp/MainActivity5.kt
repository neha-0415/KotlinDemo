package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

fun FeedingManual(): String {
    var d1 = RandomDay()
    var f1 = FishFood(d1)
    return f1
}

fun RandomDay():String{
    var arr = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    var day = arr[Random().nextInt(7)]
    return day
}

fun FishFood(day:String): String{
    var food=""
    when(day)
    {
        "Monday"->food = "Flakes"
        "Tuesday"->food = "Pellets"
        "Wednesday"->food ="RedWorms"
        "Thursday"->food ="Granules"
        "Friday" -> food ="Mosquito"
        "Saturday" -> food= "Lettuce"
        "Sunday" -> food = "Plankton"
    }
    return food

}

fun isHot(temp:Float):Boolean = temp>30

fun isDirty(dirt:Float):Boolean = dirt>30

fun isSunday(day:String):Boolean = day=="Sunday"

fun ShldChangeWater(day:String , temp:Float , dirt:Float):Boolean{
    if(isHot(temp)) return true
    if(isDirty(dirt)) return true
    if(isSunday(day)) return true
    return false

}
class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var d = findViewById<TextView>(R.id.day)
        var dv = findViewById<EditText>(R.id.dirt)
        var t = findViewById<EditText>(R.id.temp)
        var btn = findViewById<Button>(R.id.button)
        var fishfood = findViewById<TextView>(R.id.food)
        var water = findViewById<TextView>(R.id.water)

        btn.setOnClickListener(View.OnClickListener {

            var dirtV = dv.text.toString().toFloat()
            var temp = t.text.toString().toFloat()
            var day = RandomDay()
            var str= ""
            d.setText("Day is $day")
            fishfood.setText("Today's Meal is${FeedingManual()}")
            if(ShldChangeWater(day,temp,dirtV)) str="Water should be Changed"
            else str="No Need to Change Water"
            water.setText(str)
        })

    }
}