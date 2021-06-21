package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity(),View.OnClickListener{

    private var listOfQuestions:ArrayList<Questions>? = null
    var currentPosition = 1;
    lateinit var question:TextView
    lateinit var submitBtn:Button
    var selectedChoice:Int=0
    lateinit var optionList:List<TextView>
    var score:Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var utility = Utility()
        listOfQuestions = utility.getQuestion()

        //listOfQuestions=utility.getQuestionsFromGithub()

        var name:String? = intent.getStringExtra("name")
        var q_name = findViewById<TextView>(R.id.q_name_)
        q_name.text= name

        var optionOne = findViewById<TextView>(R.id.tv_option_one)
        var optionTwo = findViewById<TextView>(R.id.tv_option_two)
        var optionThree = findViewById<TextView>(R.id.tv_option_three)
        var optionFour = findViewById<TextView>(R.id.tv_option_four)

        val progressBar = findViewById<ProgressBar>(R.id.q_progress)
        progressBar.max =listOfQuestions!!.size
        progressBar.progress=currentPosition
        submitBtn=findViewById<Button>(R.id.q_btn_next)

        optionList = listOf<TextView>(optionOne,optionTwo,optionThree,optionFour)

        setQuestion();

        for(option in optionList){
            option.setOnClickListener(this)
        }

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)

        submitBtn.setOnClickListener(View.OnClickListener {
            var ans = listOfQuestions!!.get(currentPosition-1).answer
            val btnText:String = submitBtn.text.toString()
            when(btnText){
                "SUBMIT" ->{
                    checkAnswer(ans,selectedChoice);
                    for(option in optionList){
                        option.setClickable(false)
                    }
                    if(listOfQuestions!!.size==currentPosition){
                        submitBtn.setText("FINISH")
                    }
                    else {
                        submitBtn.setText("NEXT");
                    }
                }
                "NEXT" -> {
                    currentPosition++
                    setQuestion();
                    for(option in optionList) {
                        option.setClickable(true)
                    }
                    progressBar.progress=currentPosition
                }
                "FINISH" ->{
                    Toast.makeText(this, "Your Score is $score", Toast.LENGTH_LONG).show()
                    var intent = Intent(this,SonetQuiz()::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }

    private fun checkAnswer(ans:Int,selectedChoice:Int) {
        when(selectedChoice){
            1 -> {
                optionList.get(selectedChoice-1).background=ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
                optionList.get(ans-1).background = ContextCompat.getDrawable(this, R.drawable.right_option_color)
            }
            2 -> {
                optionList.get(selectedChoice-1).background=ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
                optionList.get(ans-1).background = ContextCompat.getDrawable(this, R.drawable.right_option_color)
            }
            3 -> {
                optionList.get(selectedChoice-1).background=ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
                optionList.get(ans-1).background = ContextCompat.getDrawable(this, R.drawable.right_option_color)
            }
            4 -> {
                optionList.get(selectedChoice-1).background=ContextCompat.getDrawable(this, R.drawable.wrong_option_color)
                optionList.get(ans-1).background = ContextCompat.getDrawable(this, R.drawable.right_option_color)
            }
        }
        if(ans==selectedChoice){
            score+=1
        }
    }

    fun setQuestion() {
        var questionObject = listOfQuestions!!.get(currentPosition - 1)
        question.text = questionObject.question

        optionList.get(0).text = questionObject.optOne
        optionList.get(1).text = questionObject.optTwo
        optionList.get(2).text = questionObject.optThree
        optionList.get(3).text = questionObject.optFour

        defaultOption();
        submitBtn.setText("SUBMIT")
    }

    override fun onClick(v: View) {
        //logic
        when(v.id){
            R.id.tv_option_one -> {
               selectedoption(optionList.get(0),R.drawable.selected_option_border_bg)
                selectedChoice=1
            }
            R.id.tv_option_two -> {
                selectedoption(optionList.get(1),R.drawable.selected_option_border_bg)
                selectedChoice=2
            }
            R.id.tv_option_three -> {
                selectedoption(optionList.get(2),R.drawable.selected_option_border_bg)
                selectedChoice=3
            }
            R.id.tv_option_four -> {
                selectedoption(optionList.get(3),R.drawable.selected_option_border_bg)
                selectedChoice=4
            }
        }
    }

    private fun selectedoption(tv: TextView,id:Int){
        defaultOption();
        tv.background = ContextCompat.getDrawable(this, id)
        selectedChoice=id
    }

    private fun defaultOption() {
        optionList.get(0).background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        optionList.get(1).background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        optionList.get(2).background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        optionList.get(3).background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
    }
}