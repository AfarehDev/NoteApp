package com.example.noteapp.presentation.noteScreen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DeleteItem(
    onClick:()->Unit
) {
    OutlinedButton(
        onClick = {
            onClick()
        }
    ) {
        Icon(Icons.Outlined.Delete  , "Floating action button.",tint = Color(0xFFDB7397))
    }
}