package com.seniorglez.brainfuck;

import com.seniorglez.brainfuck.exceptions.UnsupportedValueException;

/**
 * DataCell class wraps an Array of DataCell instances and a int witch represents a position of the Array.It only allows access/modifie its values through 
 * its public methods, which represent the instructions of the Brainfuck language specification.
 */
public class DataGrid
{
    private DataCell[] dataArray;
    private int pointer;

    public DataGrid()
    {
        this.dataArray = new DataCell[7500];
        this.pointer = 0;
        initDataArray(dataArray);
    }

    private void initDataArray(DataCell[] dataArray)
    {
        for(int i = 0; i < dataArray.length; i++)
        {
            dataArray[i] = new DataCell();
        }
    }

    public void incrementPoiner() 
    {
        if(pointer == (dataArray.length -1))
        {
            pointer = 0;
        } else {
            pointer++;
        }
    }

    public void decrementPoiner()
    {
        if(pointer == 0)
        {
            pointer = dataArray.length -1;
        } else {
            pointer--;
        }
    }

    public void incrementValue()
    {
        this.dataArray[pointer].incrementValue();
    }

    public void decrementValue()
    {
        this.dataArray[pointer].decrementValue();
    }

    public char getCurrentValue()
    {
        return this.dataArray[pointer].getValue();
    }

    public void setCurrentValue(char mander) throws UnsupportedValueException
    {
        this.dataArray[pointer].setValue(mander);
    }
}