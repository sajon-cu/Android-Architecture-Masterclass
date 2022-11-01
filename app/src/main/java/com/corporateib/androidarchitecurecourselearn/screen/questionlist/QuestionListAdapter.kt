package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.corporateib.androidarchitecurecourselearn.R
import com.corporateib.androidarchitecurecourselearn.model.Question

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class QuestionListAdapter(
    context: Context,
    private val listener: QuestionClickListener? = null
) : ArrayAdapter<Question>(context, 0), QuestionListItemViewMvc.Listener {
    interface QuestionClickListener {
        fun onQuestionClicked(question: Question)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var mConvertView = convertView

        if(mConvertView == null) {
            val viewMvc = QuestionListItemViewMvcImpl(
                LayoutInflater.from(context),
                parent
            )

            viewMvc.registerListener(this)
            mConvertView = viewMvc.getRootView()
            mConvertView.tag = viewMvc
        }

        val question = getItem(position)!!
        val viewMvc = mConvertView.tag as QuestionListItemViewMvc
        viewMvc.bindQuestion(question)

        return mConvertView
    }

    override fun onQuestionClicked(question: Question) {
        listener?.onQuestionClicked(question)
    }
}