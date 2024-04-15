package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries

class SetAppThemePref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(theme: String) {
        localUserEntries.setAppThemePref(theme)
    }
}