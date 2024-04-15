package com.example.noteapp.presentation.noteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.models.entity.Note
import com.example.noteapp.domain.usecases.NoteUseCase
import com.example.noteapp.domain.utils.NoteOrder
import com.example.noteapp.domain.utils.OrderType
import com.example.noteapp.presentation.noteScreen.util.NotesUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCase
) : ViewModel(){

    private val _uiState = MutableStateFlow(NotesUIState())
    val uiState = _uiState.asStateFlow()

    private var recentlyDeletedNote: Note? = null


    private val _eventFlow = MutableSharedFlow<String>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    private fun getNotes(noteOrder: NoteOrder) {
        viewModelScope.launch {
            noteUseCases.getNotes(noteOrder).flowOn(Dispatchers.IO).collect{ notes ->
                _uiState.update {
                    it.copy(notes = notes, noteOrder = noteOrder)
                }
            }
        }
    }

    fun changeOrder(noteOrder: NoteOrder){
        if (_uiState.value.noteOrder::class == noteOrder::class &&
            _uiState.value.noteOrder.orderType == noteOrder.orderType
        ) {
            return
        }else{
            getNotes(noteOrder)
        }
    }

    fun deleteNote(note:Note){
        viewModelScope.launch {
            noteUseCases.deleteNote(note)
            recentlyDeletedNote = note
        }
    }

    fun restoreNote(){
        viewModelScope.launch {
            noteUseCases.insertNote(recentlyDeletedNote ?: return@launch)
            recentlyDeletedNote = null
        }
    }

    fun toggleOrderSection(){
        _uiState.update {
            it.copy(isOrderSectionVisible = !_uiState.value.isOrderSectionVisible)
        }
    }
}