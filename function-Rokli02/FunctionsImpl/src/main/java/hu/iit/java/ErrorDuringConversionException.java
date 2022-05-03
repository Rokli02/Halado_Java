package hu.iit.java;

public class ErrorDuringConversionException extends RuntimeException{
    public ErrorDuringConversionException() {
        super("Error occured during converting values!");
    }

    public ErrorDuringConversionException(String message) {
        super(message);
    }
}
