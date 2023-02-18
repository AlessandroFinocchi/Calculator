package com.example.calculator;

public class IllegalExpressionException extends Exception{

    public IllegalExpressionException() {
        super();
    }

    public IllegalExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalExpressionException(String message) {
        super(message);
    }

}
