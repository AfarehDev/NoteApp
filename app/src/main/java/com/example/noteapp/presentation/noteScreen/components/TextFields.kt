package com.example.noteapp.presentation.noteScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.outlined.CleaningServices
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


@Composable
fun EnterNoteDescriptionField(
    value:String,
    onValueChange:(String)->Unit,
    onClearClick:()->Unit,
    label:String = "",
    maxLines:Int = 1,
    isSingleLine:Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge
){


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth() ,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        textStyle = textStyle,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFF250875),
            focusedTextColor = Color(0xFF250875),

            focusedTrailingIconColor = Color.Green,
            unfocusedTrailingIconColor = Color.Green,

            unfocusedBorderColor = Color.DarkGray,
            focusedBorderColor = Color(0xFF0027FF),

            unfocusedLabelColor = Color.DarkGray,
            focusedLabelColor = Color.Black,

            ),
        label = { Text(text = label) },
        trailingIcon = {
            if (value.isNotEmpty()){
                IconButton(onClick = { onClearClick() }) {
                    Icon(imageVector = Icons.Outlined.CleaningServices, contentDescription ="icon" )
                }
            }
        },
        singleLine = isSingleLine,
        maxLines = maxLines,

    )
}


@Composable
fun EnterNoteTitleField(
    value:String,
    onValueChange:(String)->Unit,
    onClearClick:()->Unit,
    label:String = "",
    maxLines:Int = 1,
    isSingleLine:Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth() ,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        textStyle = textStyle,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFF250875),
            focusedTextColor = Color(0xFF250875),

            focusedTrailingIconColor = Color.Green,
            unfocusedTrailingIconColor = Color.Green,

            unfocusedBorderColor = Color.DarkGray,
            focusedBorderColor = Color(0xFF0027FF),

            unfocusedLabelColor = Color.DarkGray,
            focusedLabelColor = Color.Black,

        ),
        label = { Text(text = label) },
        trailingIcon = {
            if (value.isNotEmpty()){
                IconButton(onClick = { onClearClick() }) {
                    Icon(imageVector = Icons.Default.CleaningServices, contentDescription ="icon" )
                }
            }
        },
        singleLine = isSingleLine,
        maxLines = maxLines,

    )
}