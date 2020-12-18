package com.seniorglez.brainfuck;

public class UnsupportedValueException extends Exception
{
    public UnsupportedValueException(String errorMessage) {
        super(errorMessage);
    }
}