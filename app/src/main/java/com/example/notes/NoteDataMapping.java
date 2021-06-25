package com.example.notes;

import com.google.firebase.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class NoteDataMapping {

    public static class Fields{

        public final static String DATE = "date";
        public final static String TITLE = "title";
        public final static String DESCRIPTION = "description";

    }

    public static Note toNoteData(String id, Map<String, Object> doc) {

        Timestamp timeStamp = (Timestamp)doc.get(Fields.DATE);
        Note answer = new Note((String) doc.get(Fields.TITLE),
                (String) doc.get(Fields.DESCRIPTION),
                timeStamp.toDate());
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(Note noteData){
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.TITLE, noteData.getNameNote());
        answer.put(Fields.DESCRIPTION, noteData.getDescriptionNote());

        answer.put(Fields.DATE, noteData.getCreationDateNote());
        return answer;
    }

}
