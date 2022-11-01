package com.corporateib.androidarchitecurecourselearn.networking

import com.corporateib.androidarchitecurecourselearn.common.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface StackoverflowApi {
    @GET("/questions?key=" + Constants.STACKOVERFLOW_API_KEY.toString() + "&sort=activity&order=desc&site=stackoverflow&filter=withbody")
    fun fetchLastActiveQuestions(
        @Query("pagesize") pageSize: Int
    ): Call<QuestionsListResponseSchema>
}