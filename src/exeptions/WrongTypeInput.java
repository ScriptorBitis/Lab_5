package exeptions;

public class WrongTypeInput extends RuntimeException {
    public WrongTypeInput(String message) {
        super(message);
    }
}
