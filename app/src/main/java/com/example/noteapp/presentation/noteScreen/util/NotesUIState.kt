package com.example.noteapp.presentation.noteScreen.util

import com.example.noteapp.domain.models.entity.Note
import com.example.noteapp.domain.utils.NoteOrder
import com.example.noteapp.domain.utils.OrderType

data class NotesUIState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
