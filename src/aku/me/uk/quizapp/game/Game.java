package aku.me.uk.quizapp.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Round> rounds;

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
            i += round.getNumberQuestions();
        }
        return i;
    }

    public Round getRound(int roundNumber)
    {
        return rounds.get(roundNumber - 1);
    }
}
