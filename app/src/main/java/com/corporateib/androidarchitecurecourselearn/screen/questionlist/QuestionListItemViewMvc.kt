package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.view.View
import com.corporateib.androidarchitecurecourselearn.model.Question
import com.corporateib.androidarchitecurecourselearn.screen.common.ObservableViewMvc
import com.corporateib.androidarchitecurecourselearn.screen.common.ViewMvc

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface QuestionListItemViewMvc : ObservableViewMvc<QuestionListItemViewMvc.Listener> {
    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    fun bindQuestion(question: Question)
}