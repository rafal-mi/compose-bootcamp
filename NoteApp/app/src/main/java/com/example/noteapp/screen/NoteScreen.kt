package com.example.noteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.NoteButton
import com.example.noteapp.components.NoteInputText

@Composable
fun NoteScreen() {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications,
                contentDescription = "Icon")
        },
        backgroundColor = Color(0xFFDADFE3))

        // Content
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp,
                    bottom = 8.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if(it.all { c -> c.isLetter() || c.isWhitespace() })
                        title = it
                }
            )
            NoteInputText(
                modifier = Modifier.padding(top = 9.dp,
                    bottom = 8.dp),
                text = description,
                label = "Add a note",
                onTextChange = {
                    if(it.all { c -> c.isLetter() || c.isWhitespace() })
                        description = it
                }
            )
            NoteButton(text = "Save", onClick = { })

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}