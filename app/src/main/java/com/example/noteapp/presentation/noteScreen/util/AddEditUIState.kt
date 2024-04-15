package com.example.noteapp.presentation.noteScreen.util

import androidx.compose.ui.graphics.toArgb
import com.example.noteapp.domain.models.entity.Note

data class AddEditUIState(
    val title: String = "",
    val text: String = "",
    val titleHint: String = "Enter title...",
    val textHint: String = "Enter some content",
    val isTitleHintVisible: Boolean = true,
    val isTextHintVisible: Boolean = true,
    val color:Int = Note.noteColors.random().toArgb()
)
