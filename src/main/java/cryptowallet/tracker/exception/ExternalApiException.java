package cryptowallet.tracker.exception;

public class ExternalApiException extends RuntimeException{
    public ExternalApiException(Throwable err) {
        super("There was a problem communicating with the external API", err);
    }
}
