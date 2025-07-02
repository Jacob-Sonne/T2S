package com.sonne.t2s.data.repository

import com.sonne.t2s.data.dao.FlashcardDao
import com.sonne.t2s.data.entity.Flashcard
import kotlinx.coroutines.flow.Flow

class FlashcardRepository(private val flashcardDao: FlashcardDao) {

    val allFlashCards: Flow<List<Flashcard>> = flashcardDao.readFlashcards()

    suspend fun create(flashcard: Flashcard) = flashcardDao.createFlashcard(flashcard)

    suspend fun create(flashcards: List<Flashcard>) = flashcardDao.createFlashcards(flashcards)

    suspend fun read(id: Long): Flashcard? = flashcardDao.readFlashcard(id)

    suspend fun update(flashcard: Flashcard) = flashcardDao.updateFlashcard(flashcard)

    suspend fun delete(flashcard: Flashcard) = flashcardDao.deleteFlashcard(flashcard)

    suspend fun delete(id: Long) = flashcardDao.deleteFlashcard(id)

    suspend fun deleteAll() = flashcardDao.deleteAllFlashcard()
}