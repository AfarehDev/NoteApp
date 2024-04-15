package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries
class SetUserNamePref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(name: String) {
        localUserEntries.setUserNamePref(name)
    }
}