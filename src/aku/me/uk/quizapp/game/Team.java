package aku.me.uk.quizapp.game;

import java.util.List;

public class Team {
    private String name;
    private int[] scores;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
