package com.example.noteapp.domain.usecases.datastore_usecases

import com.example.noteapp.presentation.onBoardingScreen.domain.usecases.ReadTokenPref

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry,
    val clearAppEntry: ClearAppEntry,
    val setDepartmentPref: SetDepartmentPref,
    val readDepartmentPref: ReadDepartmentPref,
    val setTokenPref: SetTokenPref,
    val readTokenPref: ReadTokenPref,
    val setUserNamePref: SetUserNamePref,
    val readUserNamePref: ReadUserNamePref,
    val setUserEmailPref: SetUserEmailPref,
    val readUserEmailPref: ReadUserEmailPref,
    val setUserPasswordPref: SetUserPasswordPref,
    val readUserPasswordPref: ReadUserPasswordPref,
    val setAppLanguagePref: SetAppLanguagePref,
    val readAppLanguagePref: ReadAppLanguagePref,
    val setAppThemePref: SetAppThemePref,
    val readAppThemePref: ReadAppThemePref
)
