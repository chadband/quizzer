package aku.me.uk.quizapp.events;

public interface AnswerListener {
    void answerGiven();
    void correct();
    void incorrect();
}
