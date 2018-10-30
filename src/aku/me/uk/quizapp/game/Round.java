package aku.me.uk.quizapp.game;

import aku.me.uk.quizapp.exception.GameSettingsException;

import java.util.List;

public class Round {
    private int numberQuestions;
    private int currentQuestion;
    private List<Team> teams;

    String rules;

    public Round(int numberQuestions) {
        if (numberQuestions <= 0) {
            throw new GameSettingsException("A round must have one or more questions");
        }
        this.numberQuestions = numberQuestions;
        currentQuestion = 1;
    }

    public int getNumberQuestions() {
        return numberQuestions;
    }

    public void setNumberQuestions(int numberQuestions) {
        this.numberQuestions = numberQuestions;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public boolean nextQuestion() {
        if (currentQuestion >= numberQuestions) {
            return false;
        }

        currentQuestion++;
        return true;
    }
}
