package exceptions;

public class NotCreatedArmyException extends Exception {
    public NotCreatedArmyException() {
        super("You still not created army");
    }
}
