package com.example.notes;

public interface NoteSource {
    Note getNoteData(int position);
    int size();
}
