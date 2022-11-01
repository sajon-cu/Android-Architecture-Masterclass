package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.corporateib.androidarchitecurecourselearn.R
import com.corporateib.androidarchitecurecourselearn.model.Question

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class QuestionListViewMvc(layoutInflater: LayoutInflater, parent: ViewGroup?) :
    QuestionListAdapter.QuestionClickListener, QuestionListViewMvcImpl {

    private var mQuestionList: ListView
    private var mQuestionListAdapter: QuestionListAdapter

    private var mRootView: View

    private val mListeners = ArrayList<QuestionListViewMvcImpl.Listener>(1)

    init {
        mRootView = layoutInflater.inflate(R.layout.activity_question_list, parent, false)
        mQuestionList = findViewById(R.id.lst_items)
        mQuestionListAdapter = QuestionListAdapter(getContext(), this)
        mQuestionList.adapter = mQuestionListAdapter
    }

    override fun registerListener(listener: QuestionListViewMvcImpl.Listener) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: QuestionListViewMvcImpl.Listener) {
        mListeners.remove(listener)
    }

    override fun getContext() = getRootView().context

    override fun <T: View> findViewById(id: Int) = getRootView().findViewById<T>(id)

    override fun getRootView() = this.mRootView

    override fun onQuestionClicked(question: Question) {
        for(listener in mListeners) {
            listener.onQuestionClicked(question)
        }
    }

    override fun bindQuestions(questions: List<Question>) {
        mQuestionListAdapter.clear()
        mQuestionListAdapter.addAll(questions)
        mQuestionListAdapter.notifyDataSetChanged()
    }
}
