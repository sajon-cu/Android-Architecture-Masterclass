package com.corporateib.androidarchitecurecourselearn.screen.common

/**
 * Created by sajon on 11/1/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
interface ObservableViewMvc <ListenerType> : ViewMvc {
    fun registerListener(listener: ListenerType)
    fun unregisterListener(listener: ListenerType)
}