package aku.me.uk.quizapp.game;

import aku.me.uk.quizapp.events.RoundListener;
import aku.me.uk.quizapp.exception.GameSettingsException;

import java.util.LinkedList;
import java.util.List;

public class Round {
    private int totalQuestions;
    private int currentQuestion = 0;
    private List<RoundListener> listeners;

    public Round(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new GameSettingsException("A round must have one or more questions");
        }
        this.listeners = new LinkedList<RoundListener>();
        this.totalQuestions = totalQuestions;
    }

    public void addRoundListener(RoundListener listener) {
        this.listeners.add(listener);
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public boolean nextQuestion() {
        if (currentQuestion == 0) {
            currentQuestion = 1;
            for(RoundListener listener : listeners) {
                listener.roundStarted();
            }
            return true;
        }

        if(currentQuestion == totalQuestions) {
            for(RoundListener listener : listeners) {
                listener.roundEnded();
            }
            return false;
        }

        currentQuestion++;
        return true;
    }
}
