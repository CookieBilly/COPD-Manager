package ws.billy.app.Code.New.Questions;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import ws.billy.app.Code.New.Utility.AnswerManager;
import ws.billy.app.R;

public class QuestionFragment extends Fragment {

    BottomNavigationView bottomNavigationView;
    View view;
    Question currentq;
    TextView least_text;
    TextView most_text;
    SeekBar seekbar;
    TextView questionNum;
    TextView questionContent;
    TextView button;
    RelativeLayout buttonColour;

    // answers
    private List<Long> answers;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_question, container, false);

        // defining what the values are
        least_text = view.findViewById(R.id.leastText);
        most_text = view.findViewById(R.id.mostText);
        seekbar = view.findViewById(R.id.seekBar);
        questionNum = view.findViewById(R.id.questionNum);
        questionContent = view.findViewById(R.id.questionText);
        button = view.findViewById(R.id.submitButton);
        buttonColour = view.findViewById(R.id.buttonColour);

        // pull all questions
        Question.pullQuestions();

        // load default questions
        currentq = Question.getQuestionList().get(0);

        // setup first question
        renderQuestion();

        // listen for question submissions
        view.findViewById(R.id.submitButton).setOnClickListener(this::nextButtonClicked);

        answers = new ArrayList<>();

        return view;
    }

    private void renderQuestion() {

        // next question button
        button.setText("Next question");

        // set text
        questionNum.setText("Question #"+(Question.getQuestionList().indexOf(currentq)+1));
        questionContent.setText(currentq.getQuestion());

        // clear progress
        seekbar.setProgress(0);

        // set most & least text
        least_text.setText(currentq.getLeast_text());
        most_text.setText(currentq.getMost_text());

        // change button if needed
        if(Question.getQuestionList().size()-1 == Question.getQuestionList().indexOf(currentq)) {
            button.setText("Save Answers");
            buttonColour.setBackgroundColor(Color.parseColor("#00A300"));
        }


    }

    private void nextButtonClicked(View v) {

        // if question is last, submit answers
        if(Question.getQuestionList().size()-1 != Question.getQuestionList().indexOf(currentq)) {
            answers.add((long) seekbar.getProgress());
            currentq = Question.getQuestionList().get(Question.getQuestionList().indexOf(currentq)+1);
            renderQuestion();
        } else {
            AnswerManager.newAnswer(Question.getQuestionList(), FirebaseAuth.getInstance().getCurrentUser(), answers);
            // loading
        }

    }

}
