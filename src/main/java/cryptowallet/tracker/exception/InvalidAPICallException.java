package cryptowallet.tracker.exception;

public class InvalidAPICallException extends RuntimeException {
    public InvalidAPICallException(Throwable err) {
        super("An invalid call argument was made to the API", err);
    }
}
