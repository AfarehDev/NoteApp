package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries
class SetUserEmailPref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(email: String) {
        localUserEntries.setUserEmailPref(email)
    }
}