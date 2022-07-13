package com.example.contactcard

import android.app.Application
import com.example.contactcard.data.appDataBase
import com.example.contactcard.data.cardRepository

class App : Application() {
    val dataBase by lazy { appDataBase.getDatabase(this) }
    val repository by lazy { cardRepository(dataBase.cardDao()) }
}