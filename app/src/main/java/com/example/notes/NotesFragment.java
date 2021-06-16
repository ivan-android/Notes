package com.example.notes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class NotesFragment extends Fragment {

    public static final String CURRENT_NOTE = "CurrentNote";
    private Note currentNote;    // Текущая позиция (выбранная заметка)
    private boolean isLandscape;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    // вызывается после создания макета фрагмента, здесь мы проинициализируем список
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout)view;
        Note[] notes = Datanotes.getNonesArray();

        for(int i=0; i < notes.length; i++){
            Note note = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(note.getNameNote());
            tv.setTextSize(30);
            layoutView.addView(tv);
            tv.setOnClickListener(v -> {
                currentNote = note;
                showDescriptionNote(currentNote);
            });

        }
    }

    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CURRENT_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }

    // activity создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        // Если это не первое создание, то восстановим текущую позицию
        if (savedInstanceState != null) {
            // Восстановление текущей позиции.
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
        } else {
            // Если восстановить не удалось, то сделаем объект с первым индексом
            currentNote = Datanotes.getNonesArray()[0];
        }

        // Если можно нарисовать рядом информацию о заметке, то сделаем это
        if (isLandscape) {
            showLandDescriptionNote(currentNote);
        }
    }

    private void showDescriptionNote(Note currentNote) {
        if (isLandscape) {
            showLandDescriptionNote(currentNote);
        } else {
            showPortDescriptionNote(currentNote);
        }
    }

    // Показать в ландшафтной ориентации
    private void showLandDescriptionNote(Note currentNote) {
        // Создаём новый фрагмент с текущей позицией для вывода
        DescriptionNoteFragment detail = DescriptionNoteFragment.newInstance(currentNote);

        // Выполняем транзакцию по замене фрагмента
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.description_of_note, detail);  // замена фрагмента
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    // Показать в портретной ориентации.
    private void showPortDescriptionNote(Note currentNote) {
        // Откроем вторую activity
        Intent intent = new Intent();
        intent.setClass(getActivity(), DescriptionNoteActivity.class);
        // и передадим туда параметры
        intent.putExtra(DescriptionNoteFragment.ARG_NOTE, currentNote);
        startActivity(intent);
    }
}