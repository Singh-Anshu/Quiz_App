package com.example.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quiz_app.databinding.ActivityMainBinding
import com.example.quiz_app.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    private var questionList : ArrayList<QuestionData>? = null
    private var currentPosition : Int =1
    private var selectedOption: Int =0
    private  var score : Int = 0
    private var personName : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        personName = intent.getStringExtra("PersonName")
        binding.personName.text = personName

        questionList = SetData.getQuestion()
        Log.e("MyTest", "_______${questionList!!.size}")

       setQuestion()

        binding.opt1.setOnClickListener {
            selectedOptionStyle(binding.opt1,  1)

        }
        binding.opt2.setOnClickListener {
            selectedOptionStyle(binding.opt2,  2)

        }
        binding.opt3.setOnClickListener {
            selectedOptionStyle(binding.opt3,  3)

        }
        binding.opt4.setOnClickListener {
            selectedOptionStyle(binding.opt4,  4)

        }

        binding.submitBtn.setOnClickListener {

            if(selectedOption != 0){
                var question = questionList!![currentPosition-1]
                if(selectedOption !=  question.correct_ans){
                    setColor(selectedOption, R.drawable.wrong_option)
                }else{
                    score++
                }
                setColor(question.correct_ans, R.drawable.correct_option)

                if(currentPosition == questionList!!.size){
                    binding.submitBtn.text =" FINISH"

                }else binding.submitBtn.text = "Go To NEXT"

            }else{
                currentPosition++
                when{
                    currentPosition <= questionList!!.size ->{
                        setQuestion()
                    }
                    else ->{
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("PersonName", personName)
                        intent.putExtra("Score", score)
                        intent.putExtra("TotalQuestion", questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }

            selectedOption = 0;
        }


    }

    fun setColor(opt: Int, color: Int){

        when(opt){
            1 -> {
                binding.opt1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                binding.opt2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                binding.opt3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                binding.opt4.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    private fun setQuestion(){
        val question = questionList!![currentPosition-1]
        setOptionStyle()
        binding.progressBar.progress = currentPosition
        binding.progressBar.max = questionList!!.size
        binding.questionCountTv.text = "${currentPosition}/${questionList!!.size}"

        binding.questionText.text = question.question
        binding.opt1.text = question.option_one
        binding.opt2.text = question.option_Two
        binding.opt3.text = question.option_Three
        binding.opt4.text = question.option_Four


    }
    fun setOptionStyle(){
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0,binding.opt1)
        optionList.add(1,binding.opt2)
        optionList.add(2,binding.opt3)
        optionList.add(3,binding.opt4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(view: TextView, opt: Int){

        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}