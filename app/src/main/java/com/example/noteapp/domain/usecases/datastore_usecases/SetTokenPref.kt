package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries
class SetTokenPref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(token: String) {
        localUserEntries.setTokenPref(token)
    }
}