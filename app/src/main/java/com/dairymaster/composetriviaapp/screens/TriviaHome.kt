package com.dairymaster.composetriviaapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dairymaster.composetriviaapp.components.Questions


@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()) = Questions(viewModel)