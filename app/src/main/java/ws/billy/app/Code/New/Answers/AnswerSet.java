package ws.billy.app.Code.New.Answers;

import java.util.ArrayList;
import java.util.List;

public class AnswerSet {

    private ArrayList<Long> questionList = null;
    private ArrayList<Long> answerList = null;
    public static ArrayList<AnswerSet> answerSets = new ArrayList<>();

    public AnswerSet(ArrayList<Long> questionList, ArrayList<Long> answerList) {
        this.questionList = questionList;
        this.answerList = answerList;
        answerSets.add(this);
    }

    public AnswerSet() {
        answerSets.add(this);
    }

    public ArrayList<Long> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Long> questionList) {
        this.questionList = questionList;
    }

    public ArrayList<Long> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Long> answerList) {
        this.answerList = answerList;
    }

    public static Object[] sortGraphStatistics(List<AnswerSet> answerSet) {

        ArrayList<AnswerSet> array1 = new ArrayList<>();
        ArrayList<AnswerSet> array2 = new ArrayList<>();

        for(int i = 60; i >0; i--) {
            if(answerSet.size() > 60-i) {
                if(i > 30) {
                    array2.add(answerSet.get(i));
                } else {
                    array1.add(answerSet.get(i));
                }
            } else {
                if(i > 30) {
                    array2.add(new AnswerSet());
                } else {
                    array1.add(new AnswerSet());
                }
            }
        }

        return new Object[]{array1, array2};
    }

    public long getTotalValue() {
        long value = 0;
        for(Long l : answerList) {
            value = value + l;
        }
        return value;
    }

}
