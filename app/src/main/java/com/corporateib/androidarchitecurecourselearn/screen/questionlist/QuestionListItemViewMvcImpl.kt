package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.corporateib.androidarchitecurecourselearn.R
import com.corporateib.androidarchitecurecourselearn.model.Question
import com.corporateib.androidarchitecurecourselearn.screen.common.BaseViewMvc

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class QuestionListItemViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseViewMvc(), QuestionListItemViewMvc {
    private var mTextView: TextView
    private lateinit var mQuestion: Question
    private val mListeners = ArrayList<QuestionListItemViewMvc.Listener>(1)

    init {
        setRootView(inflater.inflate(R.layout.question_list_item, parent, false))

        mTextView = findViewById(R.id.txt_title)

        getRootView().setOnClickListener {
            for(listener in mListeners) {
                listener.onQuestionClicked(mQuestion)
            }
        }
    }

    override fun bindQuestion(question: Question) {
        mQuestion = question
        mTextView.text = question.title
    }

    override fun registerListener(listener: QuestionListItemViewMvc.Listener) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: QuestionListItemViewMvc.Listener) {
        mListeners.remove(listener)
    }
}