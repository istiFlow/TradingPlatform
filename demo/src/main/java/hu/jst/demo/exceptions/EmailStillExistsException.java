package hu.jst.demo.exceptions;

public class EmailStillExistsException extends RuntimeException {

    public EmailStillExistsException(String message) { super(message);}
}
