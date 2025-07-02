package com.sonne.t2s.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Flashcard(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val question: String,
    val answer: String,
    val questionImageUri: String? = null,
    val answerImageUri: String? = null,
)