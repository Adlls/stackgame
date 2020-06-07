package exceptions;

public class NotEnoughCoinsException extends Exception {
    public NotEnoughCoinsException() {
        super("not enough coins");
    }
}
