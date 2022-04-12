package hu.iit.java;

public class NotValidInputDataException extends RuntimeException{
    NotValidInputDataException() {
        super("Not valid input data exception!");
    }

    NotValidInputDataException(String message) {
        super(message);
    }
}
