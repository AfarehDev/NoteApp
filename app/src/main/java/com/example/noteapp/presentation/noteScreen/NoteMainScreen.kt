package com.example.noteapp.presentation.noteScreen


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.noteapp.presentation.noteScreen.components.NoteItem
import com.example.noteapp.presentation.noteScreen.components.OrderSection
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteMainScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snakeBarHostState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            snakeBarHostState.showSnackbar(message = event)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snakeBarHostState) },
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("My Notes", overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {

                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.toggleOrderSection()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Sort,
                            contentDescription = "Sort"
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add-edit-note-screen") },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        },
        content = {innerPadding->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .wrapContentSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    AnimatedVisibility(
                        visible = uiState.isOrderSectionVisible,
                        enter = fadeIn() + slideInVertically(),
                        exit = fadeOut() + slideOutVertically()
                    ) {
                        OrderSection(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            noteOrder = uiState.noteOrder,
                            onOrderChange = {
                                viewModel.changeOrder(it)
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Adaptive(150.dp), // يجب ان يكون عرض العنصر مساوي للقيمه هذه
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalItemSpacing = 8.dp
                    ) {
                        items(uiState.notes){note ->
                            NoteItem(
                                note = note,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navController.navigate(
                                            "add-edit-note-screen" +
                                                    "?noteId=${note.id}&noteColor=${note.color}"
                                        )
                                    },
                                onDeleteClick = {
                                    viewModel.deleteNote(note)
                                    scope.launch {
                                        val result = snakeBarHostState.showSnackbar(
                                            message = "Note deleted",
                                            actionLabel = "Undo",
                                            duration= SnackbarDuration.Short
                                        )
                                        if(result == SnackbarResult.ActionPerformed) {
                                            viewModel.restoreNote()
                                        }
                                    }
                                }
                            )
                        }
                    }
                }

            }//Column End
        }//content End
    )
}