package aku.me.uk.quizapp.game;

import aku.me.uk.quizapp.events.RoundListener;
import aku.me.uk.quizapp.exception.GameSettingsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class RoundTest {

    @Mock
    RoundListener roundListener; // = mock(RoundListener.class);
    // If using the annotation, use MockitoAnnotations.initMocks(this) to set them up
    // alternatively mock(Class.class) can be used.

    @Before
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

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
        r.nextQuestion();
        assertEquals(1, r.getCurrentQuestion());
        verify(roundListener).roundStarted();
    }

    @Test
    public void whenNextQuestionCalledOnFinalQuestionRoundEndEventIsCalled() {
        int numberQuestions = 5;
        Round r = new Round(numberQuestions);
        r.addRoundListener(roundListener);
        for(int i = 0, j = 1; i < numberQuestions; i++, j++) {
            r.nextQuestion();
            assertEquals(j, r.getCurrentQuestion());
        }
        verify(roundListener).roundStarted();
        r.nextQuestion();
        verify(roundListener).roundEnded();
    }
}