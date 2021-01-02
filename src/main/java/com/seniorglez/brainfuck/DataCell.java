package com.seniorglez.brainfuck;

import com.seniorglez.brainfuck.exceptions.UnsupportedValueException;

/**
 * The DataCell class wraps a numeric value between 0 and 255. An object of type DataCell contains a single field whose type is int 
 * but it only take values between 0 and 255.
 * 
 * In addition, this class provides several methods for getting and setting the value as a char. It will also check that the numerical value of the char is between 0 and 255
 */
public class DataCell
{

    private final int MAX_VALUE = 255;
    private final int MIN_VALUE = 0;
    private int value;
    
    public DataCell()
    {
        this.value = 0;
    }

    public void setValue(char mander) throws UnsupportedValueException
    {
        int i = (int)mander;
        if(i>255) throw new UnsupportedValueException("Unsupported character: " + mander);
        this.value = i;
    }

    public char getValue()
    {
        return (char)value;
    }

    public void incrementValue() 
    {
        if(value == MAX_VALUE)
        {
            this.value = MIN_VALUE;
        } else {
            this.value++;
        }
    }

    public void decrementValue() 
    {
        if(value == MIN_VALUE)
        {
            this.value = MAX_VALUE;
        } else {
            this.value--;
        }
    }
}