package com.example.notes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DescriptionNoteFragment extends Fragment {

    public static final String ARG_NOTE = "note";
    private Note note;


    public static DescriptionNoteFragment newInstance(Note note) {
        DescriptionNoteFragment f = new DescriptionNoteFragment();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Таким способом можно получить головной элемент из макета
        View view = inflater.inflate(R.layout.fragment_description_note, container, false);

        TextView textViewNameNote = view.findViewById(R.id.textViewNameNote);
        textViewNameNote.setText(note.getNameNote());
        TextView textViewDescriptionNote = view.findViewById(R.id.textViewDescriptionNote);
        textViewDescriptionNote.setText(note.getDescriptionNote());
        return view;
    }
}