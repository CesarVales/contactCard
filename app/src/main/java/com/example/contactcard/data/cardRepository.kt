package com.example.contactcard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class cardRepository(private val dao: cardDao) {

    fun insert(cardData: cardData) = runBlocking {launch(Dispatchers.IO) {
        dao.insert(cardData)
    }

    }
    fun getAll() = dao.getAll()
}