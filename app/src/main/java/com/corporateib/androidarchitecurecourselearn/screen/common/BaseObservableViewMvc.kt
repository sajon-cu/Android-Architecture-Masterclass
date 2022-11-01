package com.corporateib.androidarchitecurecourselearn.screen.common

import java.util.Collections

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
abstract class BaseObservableViewMvc <ListenerType>: BaseViewMvc(), ObservableViewMvc<ListenerType> {
    private val mListeners = hashSetOf<ListenerType>()

    override fun registerListener(listener: ListenerType) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        mListeners.remove(listener)
    }

    protected fun getListeners(): Set<ListenerType> {
        return Collections.unmodifiableSet(mListeners)
    }
}