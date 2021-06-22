package com.example.notes;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteSourceImpl implements NoteSource {
    private List<Note> dataSource;

    public NoteSourceImpl() {
        dataSource = new ArrayList<>(15);
    }

    public NoteSourceImpl init(){
        // заполнение источника данных
        dataSource.add(new Note("Купить продукты", "Описание заметки 1, ваавыфва жлыа ыва  ыв до ва", new Date()));
        dataSource.add(new Note("Отвезти кота к врачу", "Описание заметки 2, кфываппыфва жлдо ввваа", new Date()));
        dataSource.add(new Note("Оплатить счета за ЖК за две недели обязательно", "Описание заметки 3, выае ыфва жлдоывава вффа", new Date()));
        dataSource.add(new Note("Спланировать отпуск", "Описание заметки 4, каыфва ываважлдо ва", new Date()));
        dataSource.add(new Note("Продлить страховку", "Описание заметки 5, афыыфва ываважлдо ывававава", new Date()));
        dataSource.add(new Note("Записаться в сад", "Описание заметки 6, афыыфва ываважлдо ывававава", new Date()));
        dataSource.add(new Note("Позвонить домой", "Описание заметки 7, афыыфва ываважлдо ывававава", new Date()));
        dataSource.add(new Note("Выучить английский", "Описание заметки 8, афыыфва ываважлдо ывававава", new Date()));
        dataSource.add(new Note("Починить велосипед", "Описание заметки 9, афыыфва ываважлдо ывававава", new Date()));
        dataSource.add(new Note("Съездить в отпуск", "Описание заметки 10, афыыфва ываважлдо ывававава", new Date()));
        dataSource.add(new Note("Помыть машину", "Описание заметки 11, афыыфва ываважлдо ывававава", new Date()));

        return this;
    }


    public Note getNoteData(int position) {
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }
}


