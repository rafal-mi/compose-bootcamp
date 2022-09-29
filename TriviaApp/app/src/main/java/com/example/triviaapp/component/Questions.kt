package com.example.triviaapp.component

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.example.triviaapp.TriviaApplication
import com.example.triviaapp.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d(TriviaApplication.TAG, "Questions: ...Loading...")
    } else {
        questions?.forEach { questionItem ->
            Log.d(TriviaApplication.TAG, "Question: ${questionItem.question}")
        }
    }
}

