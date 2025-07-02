package com.sonne.t2s.ui.books
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.sonne.t2s.R
import com.sonne.t2s.T2SApplication
import com.sonne.t2s.data.entity.Flashcard
import com.sonne.t2s.data.repository.FlashcardRepository
import com.sonne.t2s.databinding.FragmentBooksBinding
import kotlinx.coroutines.launch
import kotlin.random.Random

class BooksFragment : Fragment(), OnFlashcardDeleteListener {

    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!
    private lateinit var booksViewModel: BooksViewModel
    private lateinit var flashcardAdapter: FlashcardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val repository = FlashcardRepository(T2SApplication.database.flashcardDao())
        val factory = BooksViewModelFactory(repository)
        booksViewModel = ViewModelProvider(this, factory)[BooksViewModel::class.java]

        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Logic
        flashcardAdapter = FlashcardAdapter(
            context = requireContext(),
            flashcards = listOf(),  // start with empty list
            listener = this
        )
        binding.flashcardListView.adapter = flashcardAdapter

        // Observe flashcards and update adapter when data changes
        booksViewModel.allFlashcards.observe(viewLifecycleOwner) { flashcards ->
            flashcardAdapter.updateData(flashcards)
        }

        binding.addButton.setOnClickListener(){
            booksViewModel.createFlashcard(Flashcard(question = Random(42).nextInt().toString(), answer = Random(12).nextInt().toString()))
        }

        binding.deleteAllButton.setOnClickListener(){
            booksViewModel.deleteAll()
        }

        return root
    }

    override fun onFlashcardDelete(flashcard: Flashcard) {
        lifecycleScope.launch {
            booksViewModel.delete(flashcard)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}