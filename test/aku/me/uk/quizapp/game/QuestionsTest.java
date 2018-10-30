package aku.me.uk.quizapp.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionsTest {

    @Test
    public void testNewQuestionsWithTwoTeamsAndTwoQuestionsWillReturnFourTotal() {
        Team t1 = new Team("home team");
        Team t2 = new Team("away team");
        short numQuestions = 2;

        Questions q = new Questions(numQuestions, new Team[]{t1, t2});
        assertEquals(numQuestions * 2, q.getTotalQuestions());
    }

    @Test
    public void testNewQuestionsSetsFirstTeamToCurrent() {
        Team t1 = new Team("home team");
        Team t2 = new Team("away team");
        short numQuestions = 2;

        Questions q = new Questions(numQuestions, new Team[]{t1, t2});
        assertEquals(t1, q.getCurrentTeam());
        assertEquals(1, q.getCurrentQuestionNumber());
    }

    @Test
    public void TestWhenNextQuestionCalledInternalCountProgressesToTheNextQuestion() {
        Team t1 = new Team("home team");
        Team t2 = new Team("away team");
        short numQuestions = 2;

        Questions q = new Questions(numQuestions, new Team[]{t1, t2});
        q.nextQuestion();
        assertEquals(2, q.getCurrentQuestionNumber());
    }
}
