package com.example.noteapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.room.ProjectDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideContext(
        application: Application
    ): Context = application

    @Provides
    @Singleton
    fun provideProjectDB(app:Application): ProjectDB {
        return Room.databaseBuilder(
             app,
             ProjectDB::class.java,
            "ProjectDB")
            .build()
    }

}