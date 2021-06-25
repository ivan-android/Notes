package com.example.notes;

public interface NoteSource {
    NoteSource init(NoteSourceResponse noteSourceResponse);
    Note getNoteData(int position);
    int size();
    void deleteNoteData(int position);
    void updateNoteData(int position, Note note);
    void addNoteData(Note note);

}
