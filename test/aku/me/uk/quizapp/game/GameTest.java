package aku.me.uk.quizapp.game;

import aku.me.uk.quizapp.exception.GameNotInProgressException;
import aku.me.uk.quizapp.exception.GameSettingsException;
import aku.me.uk.quizapp.exception.IllegalStateException;
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

    @Test(expected = GameSettingsException.class)
    public void testGameWithNoRoundsIsNotStarted()
    {
        Game game = new Game();
        game.startGame();
    }

    @Test(expected = IllegalStateException.class)
    public void testGameCannotBeStartedTwice()
    {
        Game game = new Game();
        game.addRound(new Round(3));
        game.startGame();
        game.startGame();
    }

    @Test(expected = GameNotInProgressException.class)
    public void testGameNextQuestionCannotBeCalledBeforeGameHasStarted()
    {
        Game game = new Game();
        game.addRound(new Round(3));
        game.nextQuestion();
    }

    @Test
    public void whenTheGameIsStartedRoundIsSetToOne()
    {
        Game game = new Game();
        Round r = new Round(3);
        Round r2 = new Round(2);
        game.addRound(r);
        game.addRound(r2);
        game.startGame();
        assertEquals(r, game.getCurrentRound());
        assertEquals(r2, game.getNextRound());
    }

    @Test
    public void whenRoundsIncrementedAsEachEnds()
    {
        Game game = new Game();
        Round r = new Round(2);
        Round r2 = new Round(2);
        game.addRound(r);
        game.addRound(r2);
        game.startGame();
        for(int i = 0; i < game.getQuestionCount(); i++) {
            System.out.println(game.nextQuestion());
        }
    }
}
