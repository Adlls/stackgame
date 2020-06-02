package exceptions;

public class NotEnoughPrice extends Exception {
    public NotEnoughPrice() {
        super("not enough coins");
    }
}
