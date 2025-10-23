package com.matt.note

class NoteService {
    private val repository: NoteRepository = InMemoryRepository()
    private val uuidProvider: UuidProvider = UuidProvider()
}