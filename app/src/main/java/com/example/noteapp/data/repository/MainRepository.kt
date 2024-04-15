package com.example.noteapp.data.repository

import com.example.noteapp.data.room.MainDao
import com.example.noteapp.domain.models.entity.Note
import kotlinx.coroutines.flow.Flow


class MainRepository(
    private val mainDao: MainDao,
) {


    fun getNotes(): Flow<List<Note>> = mainDao.getNotes()

    suspend fun getNoteById(id: Int): Note? = mainDao.getNoteById(id)

    suspend fun insertNote(note: Note) = mainDao.insertNote(note)

    suspend fun deleteNote(note: Note) = mainDao.deleteNote(note)

}