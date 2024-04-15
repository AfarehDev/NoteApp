package com.example.noteapp.presentation.noteScreen

import androidx.compose.ui.focus.FocusState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.models.entity.Note
import com.example.noteapp.presentation.noteScreen.util.AddEditUIState
import com.example.noteapp.domain.usecases.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddEditUIState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<String>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if(noteId != -1) {
                viewModelScope.launch {
                    noteUseCases.getNoteById(noteId)?.also { note ->
                        currentNoteId = note.id
                        _uiState.update {
                            it.copy(
                                title = note.title ,
                                isTitleHintVisible = false,
                                text = note.content,
                                isTextHintVisible = false,
                                color = note.color
                            )
                        }


                    }
                }
            }
        }
    }

    fun onSaveNote(){
        viewModelScope.launch {
            try {
                noteUseCases.insertNote(
                    Note(
                        title = _uiState.value.title,
                        content = _uiState.value.text,
                        timestamp = System.currentTimeMillis(),
                        color = _uiState.value.color,
                        id = currentNoteId
                    )
                )
                _eventFlow.emit("saveNote")
            } catch(e: Exception) {
                _eventFlow.emit( e.message ?: "Couldn't save note")
            }
        }
    }

    fun onChangeTitle(title:String) = viewModelScope.launch {
        _uiState.update { it.copy(title = title) } }

    fun onChangeTitleFocus(focusState:FocusState) = viewModelScope.launch {
        _uiState.update {
            it.copy(isTitleHintVisible = ! focusState.isFocused &&
                    _uiState.value.title.isBlank())
        }
    }

    fun onChangeText(text:String) = viewModelScope.launch {
        _uiState.update { it.copy(text = text) } }

    fun onChangeTextFocus(focusState:FocusState) = viewModelScope.launch {
        _uiState.update {
            it.copy(isTextHintVisible = ! focusState.isFocused &&
                    _uiState.value.text.isBlank()
            )
        }
    }

    fun onChangeColor(color:Int) = viewModelScope.launch {
        _uiState.update { it.copy(color = color) } }
}