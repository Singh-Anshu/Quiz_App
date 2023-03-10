package com.example.quiz_app

object  SetData {

    fun getQuestion() : ArrayList<QuestionData>{
        var que: ArrayList<QuestionData> = arrayListOf()
        val q1 = QuestionData(
            1,
            "Android is:",
            "an operating system",
            "a web browser",
            "a web server",
            "None of the above",
            1

        )

        val q2 = QuestionData(
            2,
            "Under which of the following Android is licensed?",
            " OSS",
            "Sourceforge",
            "Apache/MIT",
            " None of the abov",
            3

        )

        val q3 = QuestionData(
            3,
            "For which of the following Android is mainly developed?",
            "Servers",
            "Desktops",
            "Laptops",
            "Mobile device",
            4

        )

        val q4 = QuestionData(
            4,
            "Which of the following virtual machine is used by the Android operating system?" ,
            "JVM",
            "Dalvik virtual machine",
            "Simple virtual machine",
            "None of the above",
            2

        )

        val q5 = QuestionData(
            5,
            "What does API stand for?",
            "Application Programming Interface",
            "Android Programming Interface",
            "Android Page Interface",
            "Application Page Interface",
            1

        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return  que
    }

}