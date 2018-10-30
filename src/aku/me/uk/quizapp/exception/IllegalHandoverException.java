package aku.me.uk.quizapp.exception;

/**
 * Created by jamesc on 13/04/17.
 */

public class IllegalHandoverException extends RuntimeException {
    public IllegalHandoverException() {
        super();
    }

    public IllegalHandoverException(String detailMessage) {
        super(detailMessage);
    }
}
