package com.seniorglez.brainfuck.exceptions;
/**
 * Thrown when the interpreter attempts to consume a character in a position where is not expected. For example:
 * 
 * If the brainfuck interpreter try to consume a closing bracket without previously consuming any opening bracket, it should throw this exception.
 */
public class UnexpectedCharacterException extends Exception
{
    public UnexpectedCharacterException(String errorMessage) {
        super(errorMessage);
    }
}