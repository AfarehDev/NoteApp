package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries
import kotlinx.coroutines.flow.Flow

class ReadAppThemePref(
    private val localUserEntries: LocalUserEntries
) {
    operator fun invoke(): Flow<String> {
        return localUserEntries.readAppThemePref()
    }
}