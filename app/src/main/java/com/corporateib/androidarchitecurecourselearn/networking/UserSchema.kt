package com.corporateib.androidarchitecurecourselearn.networking

import com.google.gson.annotations.SerializedName

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
data class UserSchema(
    @SerializedName("display_name")
    private val mUserDisplayName: String?,
    @SerializedName("profile_image")
    private val mUserAvatarUrl: String?
)