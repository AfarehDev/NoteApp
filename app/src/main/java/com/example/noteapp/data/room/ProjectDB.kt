package com.example.noteapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.domain.models.entity.Note


@Database(
    entities = [Note::class],
    version = 1, exportSchema = false
)
abstract class ProjectDB: RoomDatabase() {

    abstract val dao: MainDao

}