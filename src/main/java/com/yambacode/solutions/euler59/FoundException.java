package com.yambacode.solutions.euler59;

/**
 * Created by cbyamba on 2014-03-30.
 */
public class FoundException extends RuntimeException implements Terminate {

    public FoundException() {
    }

    public FoundException(Throwable cause) {
        super(cause);
    }

    public FoundException(String message) {
        super(message);
    }

    public FoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
