package aku.me.uk.quizapp.exception;

/**
 * Created by jamesc on 13/04/17.
 */

public class GameNotInProgressException extends RuntimeException {

    public GameNotInProgressException(String detailMessage) {
        super(detailMessage);
    }

    public GameNotInProgressException() {
        super();
    }
}
