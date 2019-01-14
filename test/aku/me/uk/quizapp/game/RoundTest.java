package aku.me.uk.quizapp.game;

import aku.me.uk.quizapp.events.RoundListener;
import aku.me.uk.quizapp.exception.GameSettingsException;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;


public class RoundTest {

    @Mock
    RoundListener roundListener;

    @Test(expected = GameSettingsException.class)
    public void newRoundCannotHaveZeroQuestions() {
        new Round(0);
    }

    @Test
    public void numberOfQuestionsDefinedReturnsSame() {
        Round r = new Round(5);
        assertEquals(5, r.getTotalQuestions());
        assertEquals(0, r.getCurrentQuestion());
    }

    @Test
    public void whenNextQuestionCalledForTheFirstTimeRoundStartedEventIsCalled() {
        Round r = new Round(5);
        r.addRoundListener(roundListener);

    }
}