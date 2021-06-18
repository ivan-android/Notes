package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        firstInitNotes();
        initButtonBack();
        initButtonAdd();
        initButtonAbout();
    }

    private void firstInitNotes() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list_of_notes, new NotesFragment());
        fragmentTransaction.commit();
    }

    private void initButtonBack() {
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.list_of_notes, new NotesFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private void initButtonAdd() {
        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.list_of_notes, new AddFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private void initButtonAbout() {
        Button buttonAbout = findViewById(R.id.buttonAbout);
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.list_of_notes, new AboutFragment());
                fragmentTransaction.commit();
            }
        });
    }
}