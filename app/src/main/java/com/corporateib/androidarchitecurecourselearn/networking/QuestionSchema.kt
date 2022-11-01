package com.corporateib.androidarchitecurecourselearn.networking

import com.google.gson.annotations.SerializedName

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
class QuestionSchema(
    @SerializedName("title")
    val mTitle: String,

    @SerializedName("question_id")
    val mId: String,

    @SerializedName("body")
    val mBody: String,

    @SerializedName("owner")
    val mOwner: UserSchema
)