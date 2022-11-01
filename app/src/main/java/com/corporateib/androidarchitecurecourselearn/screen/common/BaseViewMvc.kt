package com.corporateib.androidarchitecurecourselearn.screen.common

import android.content.Context
import android.view.View

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
abstract class BaseViewMvc : ViewMvc {
    private lateinit var mRootView: View

    override fun getRootView(): View {
        return mRootView
    }

    protected fun setRootView(rootView: View) {
        mRootView = rootView
    }

    protected fun <T: View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    protected fun getContext(): Context {
        return getRootView().context
    }

}