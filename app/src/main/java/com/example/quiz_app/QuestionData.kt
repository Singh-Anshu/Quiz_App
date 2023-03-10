package com.example.quiz_app

data class QuestionData (
    var id : Int,
    var question : String,
    var option_one : String,
    var option_Two : String,
    var option_Three : String,
    var option_Four : String,
    var correct_ans : Int
        )