package com.seniorglez.brainfuck;

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
            this.value = 0;
        } else {
            this.value++;
        }
    }

    public void decrementValue() 
    {
        if(value == MIN_VALUE)
        {
            this.value = 255;
        } else {
            this.value--;
        }
    }
}