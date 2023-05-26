package cryptowallet.tracker.exception;

public class TokenSymbolNotFoundException extends RuntimeException{
    public TokenSymbolNotFoundException(Throwable err) {
        super("The token symbol has no associated ID", err);
    }
}
