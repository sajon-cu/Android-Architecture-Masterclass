package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.content.Context
import android.view.View
import com.corporateib.androidarchitecurecourselearn.model.Question

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface QuestionListViewMvcImpl {
    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    fun registerListener(listener: Listener)
    fun unregisterListener(listener: Listener)
    fun getContext(): Context?
    fun <T: View> findViewById(id: Int): T
    fun getRootView(): View
    fun bindQuestions(questions: List<Question>)
}