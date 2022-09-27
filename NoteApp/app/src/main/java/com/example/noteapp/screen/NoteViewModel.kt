package com.example.noteapp.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.NoteApplication.Companion.TAG
import com.example.noteapp.data.NotesDataSource
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.internal.aggregatedroot.codegen._com_example_noteapp_NoteApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    //private var noteList = mutableStateListOf<Note>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    if(listOfNotes.isNullOrEmpty()) {
                        Log.d(TAG, "Empty list")
                    } else {
                        _noteList.value = listOfNotes
                    }

                }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.update(note) }
    fun removeNote(note: Note) = viewModelScope.launch { repository.delete(note) }

}