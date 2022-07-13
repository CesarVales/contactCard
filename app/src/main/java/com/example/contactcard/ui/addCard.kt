package com.example.contactcard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactcard.databinding.*

class addCard : AppCompatActivity() {
    private  val binding by lazy {ActivityAddCardBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener{
            finish()
        }
        binding.btnConfirma.setOnClickListener{

        }
    }


}