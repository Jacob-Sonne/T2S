package com.sonne.t2s.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sonne.t2s.data.entity.Flashcard
import com.sonne.t2s.data.dao.FlashcardDao

@Database(entities = [Flashcard::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun flashcardDao(): FlashcardDao
}
