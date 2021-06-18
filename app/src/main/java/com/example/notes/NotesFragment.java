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
        Note[] notes = Datanotes.getNotesArray();

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

    private void showDescriptionNote(Note currentNote) {

        DescriptionNoteFragment detail = DescriptionNoteFragment.newInstance(currentNote);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.list_of_notes, detail);  // замена фрагмента
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(CURRENT_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }
}