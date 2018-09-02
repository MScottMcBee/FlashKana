package com.mscottmcbee.flashkana.application

import com.mscottmcbee.flashkana.model.FKRepository
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.ui.cardquiz.multiplechoice.CardsetMCQuizViewModel
import com.mscottmcbee.flashkana.ui.cardquiz.quiz.CardsetQuizViewModel
import com.mscottmcbee.flashkana.ui.cardquiz.quizpicker.QuizPickerViewModel
import com.mscottmcbee.flashkana.ui.cardreview.CardsetReviewViewModel
import com.mscottmcbee.flashkana.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val fkModules = module {

    viewModel { MainViewModel(get()) }
    viewModel { (id: String) -> CardsetReviewViewModel(id, get()) }
    viewModel { (id: String) -> CardsetMCQuizViewModel(id, get()) }
    viewModel { (id: String) -> CardsetQuizViewModel(id, get()) }
    viewModel { (id: String) -> QuizPickerViewModel(id, get()) }

    single { FKRepository() as Repository }

}