package com.seniorglez.brainfuck;

/**
 * 
 *
 */
public class DataGrid
{
    private DataCell[] dataArray;
    private int pointer;

    public DataGrid()
    {
        this.dataArray = new DataCell[7500];
        this.pointer = 0;
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

    public incrementValue()
    {
        this.dataArray[pointer].incrementValue();
    }

    public decrementValue()
    {
        this.dataArray[pointer].decrementValue();
    }

    public char getCurrentValue()
    {
        return this.dataArray[pointer].getValue();
    }

    public void setCurrentValue(char mander)
    {
        this.dataArray[pointer].setValue(mander);
    }
}