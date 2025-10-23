package com.matt.note

import com.matt.note.NoteRepository.Result

class InMemoryRepository : NoteRepository {

    private val cache: MutableMap<String, Note> = mutableMapOf()

    override suspend fun create(note: Note): Result<Note> {
        if (cache.containsKey(note.id)) {
            return Result.Failure(NoteRepository.Error.NoteAlreadyExists(note.id))
        }
        cache[note.id] = note
        return Result.Success(note)
    }

    override suspend fun get(id: String): Result<Note> {
        return cache[id]?.let {
            Result.Success(it)
        } ?: Result.Failure(NoteRepository.Error.NoteNotFound(id))
    }

    override suspend fun getAll(): Result<List<Note>> {
        return Result.Success(cache.values.toList())
    }

    override suspend fun update(note: Note): Result<Note> {
        return cache.put(note.id, note)?.let {
            Result.Success(note)
        } ?: Result.Failure(NoteRepository.Error.NoteNotFound(note.id))
    }

    override suspend fun delete(id: String): Result<Boolean> {
        return cache.remove(id)?.let {
            Result.Success(true)
        } ?: Result.Success(false)
    }
}