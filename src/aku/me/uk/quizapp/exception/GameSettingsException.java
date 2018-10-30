package aku.me.uk.quizapp.exception;

public class GameSettingsException extends RuntimeException {
    public GameSettingsException() {
        super();
    }

    public GameSettingsException(String message) {
        super(message);
    }
}
