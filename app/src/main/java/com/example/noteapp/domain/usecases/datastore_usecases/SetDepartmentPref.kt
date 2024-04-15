package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.domain.datastoreManager.LocalUserEntries

class SetDepartmentPref(
    private val localUserEntries: LocalUserEntries
) {
    suspend operator fun invoke(dept: String) {
        localUserEntries.setDepartmentPref(dept)
    }
}