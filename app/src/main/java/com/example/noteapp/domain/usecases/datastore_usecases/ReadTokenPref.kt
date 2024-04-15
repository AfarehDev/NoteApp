package com.example.noteapp.presentation.onBoardingScreen.domain.usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries
import kotlinx.coroutines.flow.Flow

class ReadTokenPref(
    private val localUserEntries: LocalUserEntries
) {
    operator fun invoke(): Flow<String> {
        return localUserEntries.readTokenPref()
    }
}