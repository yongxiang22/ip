public class FunkyException extends RuntimeException {
    public FunkyException(String message) {
        super(message);
    }

    public FunkyException() {
        super("Something went wrong. Please try again.");
    }
    
}

