package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries

class SetAppLanguagePref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(language: String) {
        localUserEntries.setAppLanguagePref(language)
    }
}