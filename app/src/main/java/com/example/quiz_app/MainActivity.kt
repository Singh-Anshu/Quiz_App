package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quiz_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN;

        binding.nextBtn.setOnClickListener {
            if(binding.inputEt.text.toString().isEmpty()){
                Toast.makeText(this, "Enter Your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("PersonName",binding.inputEt.text.toString().trim())
                startActivity(intent)
                finish()
            }
        }
    }
}