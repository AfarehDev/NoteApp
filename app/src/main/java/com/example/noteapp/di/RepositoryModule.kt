package com.example.noteapp.di

import com.example.noteapp.data.repository.MainRepository
import com.example.noteapp.data.room.ProjectDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMainRepository(db: ProjectDB): MainRepository {
        return MainRepository(db.dao )
    }


}