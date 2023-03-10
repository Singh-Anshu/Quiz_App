package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.quiz_app.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val username = intent.getStringExtra("PersonName")
        val score = intent.getIntExtra("Score",0)
        val totalQuestion = intent.getStringExtra("TotalQuestion")

                binding.winnerNameTv.text = username
                binding.scoreTv.text = "${score} / ${totalQuestion}"
                binding.finishBtn.setOnClickListener {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }



    }
}