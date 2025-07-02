package com.sonne.t2s.ui.books

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.sonne.t2s.R
import com.sonne.t2s.data.entity.Flashcard


interface OnFlashcardDeleteListener {
    fun onFlashcardDelete(flashcard: Flashcard)
}

class FlashcardAdapter(
    private val context: Context,
    private var flashcards: List<Flashcard>,
    private val listener: OnFlashcardDeleteListener
) : BaseAdapter() {

    override fun getCount(): Int = flashcards.size

    override fun getItem(position: Int): Flashcard = flashcards[position]

    override fun getItemId(position: Int): Long = flashcards[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val flashcard = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_flashcard, parent, false)

        val textQuestion = view.findViewById<TextView>(R.id.textQuestion)
        val textAnswer = view.findViewById<TextView>(R.id.textAnswer)
        val deleteButton = view.findViewById<ImageButton>(R.id.deleteButton)

        textQuestion.text = flashcard.question
        textAnswer.text = flashcard.answer

        deleteButton.setOnClickListener {
            // Callback to fragment or activity
            (context as? OnFlashcardDeleteListener)?.onFlashcardDelete(flashcard)
        }

        return view
    }

    fun updateData(newFlashcards: List<Flashcard>) {
        flashcards = newFlashcards
        notifyDataSetChanged()
    }
}
