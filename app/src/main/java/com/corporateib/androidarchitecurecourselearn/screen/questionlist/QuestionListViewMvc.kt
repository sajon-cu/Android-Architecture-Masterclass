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
    QuestionListAdapter.QuestionClickListener {

    interface Listener {
        fun onQuestionClicked(question: Question)
    }

    private var mQuestionList: ListView
    private var mQuestionListAdapter: QuestionListAdapter

    private var mRootView: View

    private val mListeners = ArrayList<Listener>(1)

    init {
        mRootView = layoutInflater.inflate(R.layout.activity_question_list, parent, false)
        mQuestionList = findViewById(R.id.lst_items)
        mQuestionListAdapter = QuestionListAdapter(getContext(), this)
        mQuestionList.adapter = mQuestionListAdapter
    }

    fun registerListener(listener: Listener) {
        mListeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        mListeners.remove(listener)
    }

    private fun getContext() = getRootView().context

    private fun <T: View> findViewById(id: Int) = getRootView().findViewById<T>(id)

    fun getRootView() = this.mRootView

    override fun onQuestionClicked(question: Question) {
        for(listener in mListeners) {
            listener.onQuestionClicked(question)
        }
    }

    fun bindQuestions(questions: List<Question>) {
        mQuestionListAdapter.clear()
        mQuestionListAdapter.addAll(questions)
        mQuestionListAdapter.notifyDataSetChanged()
    }
}
