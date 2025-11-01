package org.example;

public class NoSuchTrainException extends Exception{
    public NoSuchTrainException(String message) {
        super(message);
    }
}
