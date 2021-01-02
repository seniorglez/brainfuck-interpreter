package com.seniorglez.brainfuck.exceptions;

public class UnsupportedValueException extends Exception
{
    public UnsupportedValueException(String errorMessage) {
        super(errorMessage);
    }
}