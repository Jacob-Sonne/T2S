package com.sonne.t2s.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sonne.t2s.data.repository.FlashcardRepository

class BooksViewModelFactory(private val repository: FlashcardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BooksViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BooksViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
