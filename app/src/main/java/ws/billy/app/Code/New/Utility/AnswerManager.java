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
import java.util.List;
import java.util.Map;

import ws.billy.app.Code.New.Answers.AnswerSet;
import ws.billy.app.Code.New.Questions.Question;

public class AnswerManager {

    // create a new journal in db (not locally)
    public static void newAnswer(List<Question> questionList, FirebaseUser fbuser, List<Long> longList) {

        // get the db instance
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // get the collection of journals
        CollectionReference journals = db.collection("answers");

        List<String> qstring = new ArrayList<>();

        for(Question q : questionList) {
            qstring.add(q.getQuestion());
        }

        // create a post id
        Long id = Math.round(Math.random()*1000000);

        // create a new database entry (with hashmaps, nosql best)
        Map<String, Object> journal = new HashMap<>();
        journal.put("id", id);
        journal.put("user", fbuser.getUid());
        journal.put("questions", qstring);
        journal.put("answers", longList);
        journal.put("timestamp", new Timestamp(new Date()));

        // Add a new document with a generated ID
        journals.document(id.toString()).set(journal);


    }


}
