package com.matt.about

import com.matt.BuildConfig

object AboutService {

    fun version(): String = BuildConfig.VERSION
}