package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries

class ClearAppEntry(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(){
        localUserEntries.clearAppEntry()
    }
}