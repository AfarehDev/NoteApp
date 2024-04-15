package com.example.noteapp.presentation.noteScreen.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.outlined.CleaningServices
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun EnterNoteDescriptionField(
    value:String,
    onValueChange:(String)->Unit,
    onClearClick:()->Unit,
    onNextClick:()->Unit,
    modifier: Modifier = Modifier,
    label:String = "",
    maxChar:Int = 1000,
    maxLines:Int = 1,
    isSingleLine:Boolean = false,
    isFocusRequested:String = "",
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge
){

    val passwordFocusRequest = remember { FocusRequester() }

    //val maxChar = 1000

    // here in email we didn't use it but if you want to use it: just pass the isFocusRequested
    LaunchedEffect(isFocusRequested){
        if (isFocusRequested == "emailFocus"){
            passwordFocusRequest.requestFocus()
        }
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier.focusRequester(passwordFocusRequest),
        value = value,
        onValueChange = {
            //if (it.length <= maxChar){ onValueChange(it) }
            onValueChange(it)
        },
        textStyle = textStyle,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFF250875),
            focusedTextColor = Color(0xFF250875),

            focusedTrailingIconColor = Color.Green,
            unfocusedTrailingIconColor = Color.Green,

            unfocusedBorderColor = Color.DarkGray,
            focusedBorderColor = Color(0xFF0027FF),

            unfocusedLabelColor = Color.DarkGray,
            focusedLabelColor = Color.Black,

            ),
        label = { Text(text = label) },
        /*leadingIcon = {
            Icon(imageVector = Icons.Outlined.CleaningServices, contentDescription ="icon" )
        },*/
        trailingIcon = {
            if (value.isNotEmpty()){
                IconButton(onClick = { onClearClick() }) {
                    Icon(imageVector = Icons.Outlined.CleaningServices, contentDescription ="icon" )
                }
            }
        },
        /*supportingText = {
            Text(
                text = "${value.length} / $maxChar",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
            )
        },*/
        singleLine = isSingleLine,
        maxLines = maxLines,
        /*keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                onNextClick()
            }
        ),*/
        //isError = !(value.matches(emailRegex)),

    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EnterNoteTitleField(
    value:String,
    onValueChange:(String)->Unit,
    onClearClick:()->Unit,
    onNextClick:()->Unit,
    modifier: Modifier = Modifier,
    label:String = "",
    maxLines:Int = 1,
    isSingleLine:Boolean = false,
    isFocusRequested:String = "",
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
){

    val passwordFocusRequest = remember { FocusRequester() }

    val maxChar = 200

    // here in email we didn't use it but if you want to use it: just pass the isFocusRequested
    LaunchedEffect(isFocusRequested){
        if (isFocusRequested == "emailFocus"){
            passwordFocusRequest.requestFocus()
        }
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier.focusRequester(passwordFocusRequest),
        value = value,
        onValueChange = {
            //if (it.length <= maxChar){ onValueChange(it) }
            onValueChange(it)
        },
        textStyle = textStyle,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFF250875),
            focusedTextColor = Color(0xFF250875),

            focusedTrailingIconColor = Color.Green,
            unfocusedTrailingIconColor = Color.Green,

            unfocusedBorderColor = Color.DarkGray,
            focusedBorderColor = Color(0xFF0027FF),

            unfocusedLabelColor = Color.DarkGray,
            focusedLabelColor = Color.Black,

        ),
        label = { Text(text = label) },
        /*leadingIcon = {
            Icon(imageVector = Icons.Outlined.TextFields, contentDescription ="icon" )
        },*/
        trailingIcon = {
            if (value.isNotEmpty()){
                IconButton(onClick = { onClearClick() }) {
                    Icon(imageVector = Icons.Default.CleaningServices, contentDescription ="icon" )
                }
            }
        },
        /*supportingText = {
            Text(
                text = "${value.length} / $maxChar",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
            )
        },*/
        singleLine = isSingleLine,
        maxLines = maxLines,
        /*keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Default
        ),*/
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                onNextClick()
            }
        ),
        //isError = !(value.matches(emailRegex)),

    )
}