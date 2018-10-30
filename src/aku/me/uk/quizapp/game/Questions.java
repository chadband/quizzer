package aku.me.uk.quizapp.game;

/** @todo Think a rename may be in order */
public class Questions {

    private int numberOfQuestionsPerTeam;
    private Team[] teams;

    private int totalQuestions;
    private int currentQuestionNumber;
    private int currentTeamIndex;

    public Questions(int numberOfQuestionsPerTeam, Team[] teams) {
        this.numberOfQuestionsPerTeam = numberOfQuestionsPerTeam;
        this.teams = teams;
        this.totalQuestions = numberOfQuestionsPerTeam * teams.length;
        this.currentQuestionNumber = 1;
        this.currentTeamIndex = 0;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public Team getCurrentTeam() {
        return this.teams[this.currentTeamIndex];
    }

    public boolean nextQuestion() {

        return true;
    }
}
