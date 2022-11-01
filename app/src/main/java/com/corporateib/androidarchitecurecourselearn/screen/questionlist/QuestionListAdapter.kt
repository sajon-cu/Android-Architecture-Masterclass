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
) : ArrayAdapter<Question>(context, 0) {
    interface QuestionClickListener {
        fun onQuestionClicked(question: Question)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var mConvertView = convertView

        if(mConvertView == null) {
            mConvertView = LayoutInflater.from(parent.context).inflate(R.layout.question_list_item, parent, false)
        }

        val question = getItem(position)!!
        val txtTitle = mConvertView?.findViewById<TextView>(R.id.txt_title)
        txtTitle?.text= question.title

        mConvertView?.setOnClickListener {
            onQuestionClicked(question)
        }

        // return super.getView(position, convertView, parent)
        return mConvertView!!
    }

    private fun onQuestionClicked(question: Question) {
        listener?.onQuestionClicked(question)
    }
}