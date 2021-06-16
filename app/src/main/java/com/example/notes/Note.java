package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String nameNote;
    private String descriptionNote;

    public Note(String nameNote, String descriptionNote) {
        this.nameNote = nameNote;
        this.descriptionNote = descriptionNote;
    }

    protected Note(Parcel in) {
        nameNote = in.readString();
        descriptionNote = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getNameNote() {
        return nameNote;
    }

    public String getDescriptionNote() {
        return descriptionNote;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameNote);
        dest.writeString(descriptionNote);
    }
}
