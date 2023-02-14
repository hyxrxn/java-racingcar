package exception;

public class ApplicationRuntimeException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "애플리케이션에 문제가 발생했습니다.";

    public ApplicationRuntimeException() {
        super(DEFAULT_MESSAGE);
    }
}