package ws.billy.app.Code.New.Questions;

import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private static List<Question> questionList = new ArrayList<>();

    private String question;
    private String least_text;
    private String most_text;

    public static void pullQuestions() {

        questionList.clear();

        // demo data
        new Question("Have you coughed a lot today?", "Not at all", "Constantly");
        new Question("Have you slept soundly today?", "I slept fine", "I struggled");

    }

    public static List<Question> getQuestionList() {
        return questionList;
    }

    public Question(String question, String least_text, String most_text) {
        this.question = question;
        this.least_text = least_text;
        this.most_text = most_text;
        questionList.add(this);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLeast_text() {
        return least_text;
    }

    public void setLeast_text(String least_text) {
        this.least_text = least_text;
    }

    public String getMost_text() {
        return most_text;
    }

    public void setMost_text(String most_text) {
        this.most_text = most_text;
    }
}
