package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries

class SaveAppEntry(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(){
        localUserEntries.saveAppEntry()
    }
}