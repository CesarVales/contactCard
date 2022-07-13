package com.example.contactcard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactcard.data.cardData
import com.example.contactcard.data.cardRepository
import java.lang.Exception

class MainViewModel(private val cardRepository: cardRepository) :ViewModel(){

    fun insert(card:cardData) {
        cardRepository.insert(card)
    }
    fun getAll(): LiveData<List<cardData>>{
        return cardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: cardRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T

        }
        throw IllegalAccessException("Unkown viewmodel class")
    }
}