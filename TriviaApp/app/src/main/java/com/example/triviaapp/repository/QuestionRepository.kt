package com.example.triviaapp.repository

import com.example.triviaapp.data.DataOrException
import com.example.triviaapp.model.QuestionItem
import com.example.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val listOfQuestions = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()
}