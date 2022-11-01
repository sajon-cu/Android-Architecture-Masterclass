package com.corporateib.androidarchitecurecourselearn.screen.questionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.corporateib.androidarchitecurecourselearn.R
import com.corporateib.androidarchitecurecourselearn.common.Constants
import com.corporateib.androidarchitecurecourselearn.model.Question
import com.corporateib.androidarchitecurecourselearn.networking.QuestionSchema
import com.corporateib.androidarchitecurecourselearn.networking.QuestionsListResponseSchema
import com.corporateib.androidarchitecurecourselearn.networking.StackoverflowApi
import com.corporateib.androidarchitecurecourselearn.screen.common.BaseActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class QuestionListActivity : BaseActivity(), QuestionListViewMvc.Listener {
    private var mStackoverflowApi: StackoverflowApi? = null
    private lateinit var mViewMvc: QuestionListViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewMvc = QuestionListViewMvcImpl(LayoutInflater.from(this), null)
        mViewMvc.registerListener(this)

        mStackoverflowApi = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StackoverflowApi::class.java)

        setContentView(mViewMvc.getRootView())
    }

    override fun onStart() {
        super.onStart()
        fetchQuestion()
    }

    private fun fetchQuestion() {
        mStackoverflowApi!!.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
            .enqueue(object: Callback<QuestionsListResponseSchema> {
                override fun onResponse(
                    call: Call<QuestionsListResponseSchema>,
                    response: Response<QuestionsListResponseSchema>
                ) {
                    if(response.isSuccessful) {
                        bindQuestionList(response.body()?.mQuestion)
                    } else {
                        networkCallFailed()
                    }
                }

                override fun onFailure(call: Call<QuestionsListResponseSchema>, t: Throwable) {
                    networkCallFailed()
                }
            })
    }

    private fun networkCallFailed() {
        Toast.makeText(this, R.string.error_network_call_failed, Toast.LENGTH_SHORT).show();
    }

    private fun bindQuestionList(mQuestion: List<QuestionSchema>?) {
        val questions = mutableListOf<Question>()
        mQuestion?.let {
            for (questionSchema in mQuestion) {
                questions.add(Question(questionSchema.mId, questionSchema.mTitle))
            }
        }

        mViewMvc.bindQuestions(questions)
    }

    override fun onQuestionClicked(question: Question) {
        Toast.makeText(this, question.title, Toast.LENGTH_SHORT).show()
    }
}