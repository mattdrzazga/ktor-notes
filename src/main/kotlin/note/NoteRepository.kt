package com.matt.note

interface NoteRepository {

    suspend fun create(note: Note): Result<Note>

    suspend fun get(id: String): Result<Note>

    suspend fun getAll(): Result<List<Note>>

    suspend fun update(note: Note): Result<Note>

    suspend fun delete(id: String): Result<Boolean>

    sealed interface Result<T> {
        @JvmInline
        value class Success<T>(val value: T) : Result<T>

        data class Failure<T>(val error: Error) : Result<T>
    }

    sealed class Error {

        data class NoteNotFound(val id: String) : Error()

        data class NoteAlreadyExists(val id: String) : Error()

        data class Other(val cause: Throwable) : Error()
    }
}