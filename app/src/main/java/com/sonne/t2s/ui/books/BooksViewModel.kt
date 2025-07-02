package com.sonne.t2s.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sonne.t2s.T2SApplication
import com.sonne.t2s.data.entity.Flashcard
import com.sonne.t2s.data.repository.FlashcardRepository
import kotlinx.coroutines.launch

class BooksViewModel(private val flashcardRepository: FlashcardRepository): ViewModel() {

    val allFlashcards = flashcardRepository.allFlashCards.asLiveData()

    fun createFlashcard(flashcard: Flashcard) {
        viewModelScope.launch {
            flashcardRepository.create(flashcard)
        }
    }

    fun createFlashcard(flashcards: List<Flashcard>) {
        viewModelScope.launch {
            flashcardRepository.create(flashcards)
        }
    }

    suspend fun readFlashcard(id: Long): Flashcard? {
        return flashcardRepository.read(id)
    }

    fun update(flashcard: Flashcard) {
        viewModelScope.launch {
            flashcardRepository.update(flashcard)
        }
    }

    fun delete(flashcard: Flashcard) {
        viewModelScope.launch {
            flashcardRepository.delete(flashcard)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch {
            flashcardRepository.delete(id)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            flashcardRepository.deleteAll()
        }
    }
}
