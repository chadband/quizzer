package aku.me.uk.quizapp.game;

import aku.me.uk.quizapp.events.RoundListener;
import aku.me.uk.quizapp.exception.GameNotInProgressException;
import aku.me.uk.quizapp.exception.GameSettingsException;
import aku.me.uk.quizapp.exception.IllegalStateException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Round> rounds;
    private int currentRound = -1;
    private boolean gameInProgress = false;
    private Game.Listener listener = new Game.Listener();;

    public Game()
    {
        rounds = new ArrayList<Round>();
    }

    public Round[] getRounds()
    {
        return rounds.toArray(new Round[0]);
    }

    public void addRound(Round round)
    {
        round.addRoundListener(listener);
        this.rounds.add(round);
    }
    
    public int getRoundCount()
    {
        return rounds.size();
    }

    public int getQuestionCount()
    {
        int i = 0;
        for (Round round : rounds) {
            i += round.getTotalQuestions();
        }
        return i;
    }

    public Round getCurrentRound()
    {
        return this.getRound(currentRound);
    }

    public Round getNextRound()
    {
        return this.getRound(currentRound + 1);
    }

    public Round getRound(int roundNumber)
    {
        return rounds.get(roundNumber - 1);
    }

    public boolean startGame()
    {
        if (getRoundCount() == 0) {
            throw new GameSettingsException("Game must have rounds added before it can begin.");
        }

        if (gameInProgress) {
            throw new IllegalStateException("The game has already started. End the current game first.");
        }

        this.currentRound = 1;
        return (this.gameInProgress = true);
    }

    public boolean nextQuestion()
    {
        if(!gameInProgress) {
            throw new GameNotInProgressException("The game has not yet begun");
        }

        return this.getCurrentRound().nextQuestion();
    }

    class Listener implements RoundListener {
        @Override
        public void roundStarted() {
            System.out.println("Starting round " + currentRound);
        }

        @Override
        public void roundEnded() {
            System.out.println("Ending round " + currentRound);
            currentRound++;
        }
    }
}
