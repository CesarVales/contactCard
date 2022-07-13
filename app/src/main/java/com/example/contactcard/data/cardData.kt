package com.example.contactcard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class cardData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val tel : String,
    val email: String,
    val obs: String,
    val background:String
)
