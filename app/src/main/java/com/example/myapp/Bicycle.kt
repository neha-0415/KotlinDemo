package com.example.myapp

class Bicycle {
    var brandName:String = ""
    var modelYear:Int = 0

    get() {
        return field
    }

    set(value){
        field = value
    }

    fun display()
    {
        println("$brandName -> $modelYear")
    }
}