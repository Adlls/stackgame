package exceptions;

public class NotEnoughPriceException extends Exception {
    public NotEnoughPriceException() {
        super("not enough coins");
    }
}
