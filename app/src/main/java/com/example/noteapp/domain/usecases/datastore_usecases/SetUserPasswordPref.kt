package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries
class SetUserPasswordPref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(password: String) {
        localUserEntries.setUserPasswordPref(password)
    }
}