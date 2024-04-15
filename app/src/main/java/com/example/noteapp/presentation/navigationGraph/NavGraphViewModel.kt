package com.example.noteapp.presentation.navigationGraph

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavGraphViewModel @Inject constructor() : ViewModel() {

    private val _startDestination = mutableStateOf("main-navigation")
    val startDestination: State<String> = _startDestination


}