package com.example.notes;

public class Datanotes {

    public static Note[] getNotesArray() {
        Note[] notes = new Note[5];
        notes[0] = new Note("Заметка 1", "Описание заметки 1, ваавыфва жлыа ыва  ыв до ва");
        notes[1] = new Note("Заметка 2", "Описание заметки 2, кфываппыфва жлдо ввваа");
        notes[2] = new Note("Заметка 3", "Описание заметки 3, выае ыфва жлдоывава вффа");
        notes[3] = new Note("Заметка 4", "Описание заметки 4, каыфва ываважлдо ва");
        notes[4] = new Note("Заметка 5", "Описание заметки 5, афыыфва ываважлдо ывававава");

        return notes;
    }
}
