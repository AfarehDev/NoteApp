package com.example.noteapp.presentation.noteScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.models.entity.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    //cornerRadius: Dp = 10.dp,
    //cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = modifier.background(Color(note.color) , shape = RoundedCornerShape(10.dp))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(note.color) , shape = RoundedCornerShape(10.dp))
            ,
                //.padding(end = 32.dp)
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodySmall,
                color = Color.DarkGray,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )

            Divider(modifier=Modifier.padding(4.dp))

            DeleteItem {
                onDeleteClick()
            }
        }

    }
}