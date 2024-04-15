package com.example.noteapp.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.noteapp.domain.datastoreManager.LocalUserEntries
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * الكلاس الذي يحتوي على دوال الادخال والقراءه من الداتا ستور, مثل الداو في الرووم والسرفس في الرتيروفيت .
 * ايضا يعتبر الريبو للداتا ستور .
 * **/
class LocalUserEntriesImp(
    private val context: Context
) : LocalUserEntries {

    // App Entry
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.APP_ENTRY] = true
        }
    }

    override suspend fun clearAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.APP_ENTRY] = false
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.APP_ENTRY] ?: false
        }
    }

    // Department Pref
    override suspend fun setDepartmentPref(dept: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.Department] = dept
        }
    }

    override fun readDepartmentPref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.Department] ?: ""
        }
    }

    // Token Pref
    override suspend fun setTokenPref(token: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.Token] = token
        }
    }

    override fun readTokenPref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.Token]?: ""
        }
    }

    // StudentName Pref
    override suspend fun setUserNamePref(name: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.StudentName] = name
        }
    }

    override fun readUserNamePref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.StudentName]?: ""
        }
    }

    // StudentEmail Pref
    override suspend fun setUserEmailPref(email: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.StudentEmail] = email
        }
    }

    override fun readUserEmailPref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.StudentEmail]?: ""
        }
    }

    // StudentPassword Pref
    override suspend fun setUserPasswordPref(password: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.StudentPassword] = password
        }
    }

    override fun readUserPasswordPref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.StudentPassword]?: ""
        }
    }

    // AppLanguage Pref
    override suspend fun setAppLanguagePref(language: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.AppLanguage] = language
        }
    }

    override fun readAppLanguagePref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.AppLanguage]?: "ar"
        }
    }

    // AppTheme Pref
    override suspend fun setAppThemePref(theme: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.AppTheme] = theme
        }
    }

    override fun readAppThemePref(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.AppTheme]?: ""
        }
    }

}