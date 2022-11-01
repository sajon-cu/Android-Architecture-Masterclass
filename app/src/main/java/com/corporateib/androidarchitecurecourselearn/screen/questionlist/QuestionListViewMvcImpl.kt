package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import com.corporateib.androidarchitecurecourselearn.R
import com.corporateib.androidarchitecurecourselearn.model.Question
import com.corporateib.androidarchitecurecourselearn.screen.common.BaseObservableViewMvc
import com.corporateib.androidarchitecurecourselearn.screen.common.BaseViewMvc
/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class QuestionListViewMvcImpl(
    layoutInflater: LayoutInflater, parent: ViewGroup?
) : BaseObservableViewMvc<QuestionListViewMvc.Listener>(),
    QuestionListViewMvc,
    QuestionListAdapter.QuestionClickListener
{
    private var mQuestionList: ListView
    private var mQuestionListAdapter: QuestionListAdapter

    // private val mListeners = ArrayList<QuestionListViewMvc.Listener>(1)

    init {
        setRootView(layoutInflater.inflate(R.layout.activity_question_list, parent, false))
        mQuestionList = findViewById(R.id.lst_items)
        mQuestionListAdapter = QuestionListAdapter(getContext(), this)
        mQuestionList.adapter = mQuestionListAdapter
    }

    override fun onQuestionClicked(question: Question) {
        for(listener in getListeners()) {
            listener.onQuestionClicked(question)
        }
    }

    override fun bindQuestions(questions: List<Question>) {
        mQuestionListAdapter.clear()
        mQuestionListAdapter.addAll(questions)
        mQuestionListAdapter.notifyDataSetChanged()
    }
}