package com.dairymaster.composetriviaapp.repository

import android.util.Log
import com.dairymaster.composetriviaapp.data.local.DataOrException
import com.dairymaster.composetriviaapp.data.remote.QuestionApi
import com.dairymaster.composetriviaapp.model.Question
import com.dairymaster.composetriviaapp.model.QuestionItem
import java.lang.Exception
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()){
                dataOrException.loading = false
            }
        } catch (exception: Exception){
            dataOrException.loading = false
            dataOrException.e = exception
            Log.d("Exception", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}