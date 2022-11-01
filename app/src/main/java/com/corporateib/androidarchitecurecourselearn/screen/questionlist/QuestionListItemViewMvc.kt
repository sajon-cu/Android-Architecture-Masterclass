package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.view.View
import com.corporateib.androidarchitecurecourselearn.model.Question

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface QuestionListItemViewMvc {
    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestion(question: Question)
    fun getRootView(): View
    fun registerListener(listener: Listener)
    fun unregisterListener(listener: Listener)
}