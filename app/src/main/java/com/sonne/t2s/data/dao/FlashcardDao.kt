package com.sonne.t2s.data.dao

import androidx.room.*
import com.sonne.t2s.data.entity.Flashcard
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashcardDao {

    // CRUD: Create, Read, Update, Delete
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createFlashcard(flashcard: Flashcard)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createFlashcards(flashcards: List<Flashcard>)

    @Query("SELECT * FROM Flashcard WHERE id = :id")
    suspend fun readFlashcard(id: Long): Flashcard?

    @Query("SELECT * FROM Flashcard ORDER BY id ASC")
    fun readFlashcards(): Flow<List<Flashcard>>

    @Update
    suspend fun updateFlashcard(flashcard: Flashcard)

    @Delete
    suspend fun deleteFlashcard(flashcard: Flashcard)

    @Query("DELETE FROM Flashcard WHERE id = :id")
    suspend fun deleteFlashcard(id: Long)

    @Query("DELETE FROM Flashcard")
    suspend fun deleteAllFlashcard()

}