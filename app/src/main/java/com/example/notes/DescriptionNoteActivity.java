package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class DescriptionNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_note);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // Если эта activity запускается первый раз (всегда первый раз),
            // то перенаправим параметр фрагменту
            DescriptionNoteFragment details = new DescriptionNoteFragment();
            details.setArguments(getIntent().getExtras());
            // Добавим фрагмент на activity
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, details).commit();
        }
    }
}