package com.example.noteapp.domain.datastoreManager

import kotlinx.coroutines.flow.Flow

/**
 *  هنا نضع الدوال التي نريدها من الداتا ستور في طبقة الداتا .
 *  **/
interface LocalUserEntries {

    // App Entry
    suspend fun saveAppEntry()
    suspend fun clearAppEntry()
    fun readAppEntry(): Flow<Boolean>

    // Student Info
    suspend fun setDepartmentPref(dept: String)
    fun readDepartmentPref(): Flow<String>

    suspend fun setTokenPref(token: String)
    fun readTokenPref(): Flow<String>

    suspend fun setUserNamePref(name: String)
    fun readUserNamePref(): Flow<String>

    suspend fun setUserEmailPref(email: String)
    fun readUserEmailPref(): Flow<String>

    suspend fun setUserPasswordPref(password: String)
    fun readUserPasswordPref(): Flow<String>

    // App Pref
    suspend fun setAppLanguagePref(language: String)
    fun readAppLanguagePref(): Flow<String>
    suspend fun setAppThemePref(theme: String)
    fun readAppThemePref(): Flow<String>


}
