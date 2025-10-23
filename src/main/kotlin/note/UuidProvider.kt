package com.matt.note

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class UuidProvider {

    @OptIn(ExperimentalUuidApi::class)
    fun random(): String = Uuid.random().toString()
}