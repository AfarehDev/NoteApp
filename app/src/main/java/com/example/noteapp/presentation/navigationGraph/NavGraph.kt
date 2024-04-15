package com.example.noteapp.presentation.navigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.noteapp.presentation.noteScreen.AddEditNoteScreen
import com.example.noteapp.presentation.noteScreen.NoteMainScreen


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        navigation(
            route = "main-navigation",
            //startDestination = "main-screen"
            startDestination = "main-note-screen"
        ) {


            composable(route = "main-note-screen"){

               NoteMainScreen(navController = navController)
            }

            composable(
                route = "add-edit-note-screen" +
                        "?noteId={noteId}&noteColor={noteColor}",
                arguments = listOf(
                    navArgument(
                        name = "noteId"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                    navArgument(
                        name = "noteColor"
                    ) {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                )
            ) {
                val color = it.arguments?.getInt("noteColor") ?: -1
                AddEditNoteScreen(
                    navController = navController,
                    noteColor = color
                )
            }


        }
    }
}