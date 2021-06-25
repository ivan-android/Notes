package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private String id;
    private String nameNote;
    private String descriptionNote;
    private Date creationDateNote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Note(String nameNote, String descriptionNote, Date creationDateNote) {
        this.nameNote = nameNote;
        this.descriptionNote = descriptionNote;
        this.creationDateNote = creationDateNote;
    }

    protected Note(Parcel in) {
        nameNote = in.readString();
        descriptionNote = in.readString();
        creationDateNote = new Date(in.readLong());

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

    public Date getCreationDateNote() {return creationDateNote;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameNote);
        dest.writeString(descriptionNote);
        dest.writeLong(creationDateNote.getTime());
    }
}
