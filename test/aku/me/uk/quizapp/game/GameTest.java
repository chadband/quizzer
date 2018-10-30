package aku.me.uk.quizapp.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testNewGameHasNoRound()
    {
        Game game = new Game();
        assertEquals(0, game.getRoundCount());
    }

    @Test
    public void testNewGameHasNoRoundAndNoQuestions()
    {
        Game game = new Game();
        assertEquals(0, game.getRoundCount());
        assertEquals(0, game.getQuestionCount());
    }

    @Test
    public void testGameWithRoundAddedReturnsCorrectNumber()
    {
        Game game = new Game();
        Round round = new Round(4);
        game.addRound(round);
        assertEquals(1, game.getRoundCount());
        assertArrayEquals(new Round[] {round}, game.getRounds());
        assertEquals(round, game.getRound(1));
    }

    @Test
    public void testGameWithRoundAddedReturnsQuestionCount()
    {
        Game game = new Game();
        Round round = new Round(5);
        Round round2 = new Round(6);
        game.addRound(round);
        game.addRound(round2);
        assertEquals(2, game.getRoundCount());
        assertEquals(11, game.getQuestionCount());
    }
}
