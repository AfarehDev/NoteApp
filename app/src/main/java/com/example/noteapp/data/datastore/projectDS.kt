package com.example.noteapp.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

private val readOnlyProperty = preferencesDataStore(name = "my_data_store")

val Context.dataStore: DataStore<Preferences> by readOnlyProperty

//val Context.encryptedDataStore by dataStore("" , serelizer)

object PreferenceKeys {
    val APP_ENTRY           = booleanPreferencesKey("appEntry")
    val Department          = stringPreferencesKey("department")
    val Token               = stringPreferencesKey("token")
    val StudentName         = stringPreferencesKey("userName")
    val StudentEmail        = stringPreferencesKey("userEmail")
    val StudentPassword     = stringPreferencesKey("userPassword")
    val AppLanguage         = stringPreferencesKey("appLanguage")
    val AppTheme            = stringPreferencesKey("appTheme")
}