package com.example.noteapp.di

import android.app.Application
import com.example.noteapp.data.datastore.LocalUserEntriesImp
import com.example.noteapp.domain.datastoreManager.LocalUserEntries
import com.example.noteapp.domain.usecases.datastore_usecases.AppEntryUseCases
import com.example.noteapp.domain.usecases.datastore_usecases.ClearAppEntry
import com.example.noteapp.domain.usecases.datastore_usecases.ReadAppEntry
import com.example.noteapp.domain.usecases.datastore_usecases.ReadAppLanguagePref
import com.example.noteapp.domain.usecases.datastore_usecases.ReadAppThemePref
import com.example.noteapp.domain.usecases.datastore_usecases.ReadDepartmentPref
import com.example.noteapp.domain.usecases.datastore_usecases.ReadUserEmailPref
import com.example.noteapp.domain.usecases.datastore_usecases.ReadUserNamePref
import com.example.noteapp.domain.usecases.datastore_usecases.ReadUserPasswordPref
import com.example.noteapp.domain.usecases.datastore_usecases.SaveAppEntry
import com.example.noteapp.domain.usecases.datastore_usecases.SetAppLanguagePref
import com.example.noteapp.domain.usecases.datastore_usecases.SetAppThemePref
import com.example.noteapp.domain.usecases.datastore_usecases.SetDepartmentPref
import com.example.noteapp.domain.usecases.datastore_usecases.SetTokenPref
import com.example.noteapp.domain.usecases.datastore_usecases.SetUserEmailPref
import com.example.noteapp.domain.usecases.datastore_usecases.SetUserNamePref
import com.example.noteapp.domain.usecases.datastore_usecases.SetUserPasswordPref
import com.example.noteapp.presentation.onBoardingScreen.domain.usecases.ReadTokenPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreAppEntryModule {


    @Provides
    @Singleton
    fun provideLocalUserEntries(
        application: Application
    ): LocalUserEntries = LocalUserEntriesImp(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserEntries: LocalUserEntries
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserEntries),
        saveAppEntry = SaveAppEntry(localUserEntries),
        clearAppEntry = ClearAppEntry(localUserEntries),
        setDepartmentPref = SetDepartmentPref(localUserEntries),
        readDepartmentPref = ReadDepartmentPref(localUserEntries),
        setTokenPref = SetTokenPref(localUserEntries),
        readTokenPref = ReadTokenPref(localUserEntries),
        setUserNamePref = SetUserNamePref(localUserEntries),
        readUserNamePref = ReadUserNamePref(localUserEntries),
        setUserEmailPref = SetUserEmailPref(localUserEntries),
        readUserEmailPref = ReadUserEmailPref(localUserEntries),
        setUserPasswordPref = SetUserPasswordPref(localUserEntries),
        readUserPasswordPref = ReadUserPasswordPref(localUserEntries),
        setAppLanguagePref = SetAppLanguagePref(localUserEntries),
        readAppLanguagePref = ReadAppLanguagePref(localUserEntries),
        setAppThemePref = SetAppThemePref(localUserEntries),
        readAppThemePref = ReadAppThemePref(localUserEntries)
    )

}