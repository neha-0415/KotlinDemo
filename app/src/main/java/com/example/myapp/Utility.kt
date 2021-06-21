package com.example.myapp

import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Utility {
    fun getQuestion():ArrayList<Questions>{
        var list = ArrayList<Questions>()
        //logic
        var q1 = Questions(1,"What is kotlin?","Scripting Language","Programming Language","Modern Language","Assembly Language",3)
        var q2 = Questions(2,"What is Java?","Scripting Language","Programming Language","Modern Language","Assembly Language",2)
        var q3 = Questions(3,"What is Browser?","Apple Software","Google Tool","Desktop/Mobile Client","Language",3)

        list.add(q1)
        list.add(q2)
        list.add(q3)
        return list;
    }

    fun getQuestionsFromGithub():ArrayList<Questions>{
        var list = ArrayList<Questions>()
        //logic
        Thread(Runnable {
            var response = URL("https://raw.githubusercontent.com/neha-0415/SONET-Kotlin-1/patch-1/questions.json").readText()

        }).start()

        return list;
    }
}