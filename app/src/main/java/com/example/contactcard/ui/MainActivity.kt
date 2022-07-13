package com.example.contactcard.ui

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.contactcard.App
import com.example.contactcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by  viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { cardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((binding.root))
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnadd.setOnClickListener{
            val intent = Intent(this@MainActivity,addCard::class.java)// mudar da tela main para add
            startActivity(intent)

            /*adapter.listenerShare = { card ->
                Image.share(this@MainActivity, card)
            }*/
        }
        fun getAllBusinessCard() {
            mainViewModel.getAll().observe(this) { businessCards ->
                adapter.submitList(businessCards)
            }
        }
    }
}