package com.example.noteapp.domain.usecases


import com.example.noteapp.data.repository.MainRepository
import com.example.noteapp.domain.models.entity.Note
import com.example.noteapp.domain.utils.NoteOrder
import com.example.noteapp.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteUseCase @Inject constructor(
    private val repository: MainRepository
) {

    fun getNotes(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }

    suspend fun getNoteById(id: Int): Note? {
        return repository.getNoteById(id)
    }

    suspend fun insertNote(note: Note) {
        repository.insertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        repository.deleteNote(note)
    }
}