package ws.billy.app.Code.New.Utility;

// I ended up getting really annoyed making like 5 functions in different classes, so
// here's a centralized journal manager.


import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ws.billy.app.Code.New.Answers.AnswerSet;

public class MessageManager {

    // static list of journals, used for identifying which is clicked
    public static ArrayList<AnswerSet> journals;

    // create a new journal in db (not locally)
    public static void newJournal(String imageUrl, String text, FirebaseUser fbuser, GeoPoint geolocation) {

        // get the db instance
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // get the collection of journals
        CollectionReference journals = db.collection("journals");

        // create a post id
        Long id = Math.round(Math.random()*10000);

        // create a new database entry (with hashmaps, nosql best)
        Map<String, Object> journal = new HashMap<>();
        journal.put("id", id);
        journal.put("prourl", fbuser.getPhotoUrl()); // this one should be removed, would be easier to save id and pull from db
        journal.put("url", imageUrl);
        journal.put("text", text);
        journal.put("userid", fbuser.getUid());
        journal.put("geolocation", geolocation);
        journal.put("timestamp", new Timestamp(new Date()));

        // Add a new document with a generated ID
        journals.document(id.toString()).set(journal);


    }


}
