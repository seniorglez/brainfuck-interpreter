package com.seniorglez.brainfuck;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.seniorglez.brainfuck.exceptions.UnexpectedCharacterException;

/**
 * This class provides the method run which execute the queued Brainfuck code.
 */
public class BrainfuckInterpreter
{
        private DataGrid dataGrid;
        private LinkedList queue;
        private int position;

    public BrainfuckInterpreter(DataGrid dataGrid, LinkedList queue)
    {
        this.dataGrid = dataGrid;
        this.queue = queue;
        position = -1;
    }

    public void run() throws UnexpectedCharacterException
    {
        while(nextChar()) consumeChar(getCurrentChar(), dataGrid);
    }

    public void reset() throws UnexpectedCharacterException {
        this.position = -1;
        run();
    }

    public static void enqueue(InputStream inputStream, LinkedList queue)
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                enqueue(line, queue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enqueue(String line, LinkedList queue)
    {
        IntStream intStream = line.chars();
        queue.addAll(intStream.boxed().collect(Collectors.toList())); //boxed turns the int Stream into a Integer Stream which is collected into a List of Objets
    }

    private void consumeChar(int c, DataGrid dataGrid) throws UnexpectedCharacterException {
        switch(c) {
            case 43://+
                dataGrid.incrementValue();
                break;
            case 44://,
                //dataGrid.setCurrentValue();
                break;
            case 45://-
                dataGrid.decrementValue();
                break;
            case 46://.
                System.out.print(dataGrid.getCurrentValue());
                break;
            case 60://<
                dataGrid.decrementPoiner();
                break;
            case 62://>
                dataGrid.incrementPoiner();
                break;
            case 91://[
                LinkedList queue= new LinkedList();
                while (lookFor(93)!= -1) queue.add(Integer.valueOf(getCurrentChar()));
                BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter(dataGrid,queue);
                while (dataGrid.getCurrentValue() != 0) brainfuckInterpreter.reset();
                break;
            case 93://]
                throw new UnexpectedCharacterException("Unexpected closing braket");
        }
    }

    private boolean nextChar() 
    {
        if(++position < this.queue.size()) {
            return true;
        } 
        return false;
    }

    private int getCurrentChar() {
        Integer integer = (Integer) queue.get(position);
        return integer.intValue();
    }

    private int lookFor(int charToConsume) 
    {
        nextChar();
        int ch = getCurrentChar();
        if ( charToConsume == ch) {
            return -1;
        } 
        return ch;
    }

    public static void main( String[] args ) 
    {
        DataGrid dataGrid = new DataGrid();
        LinkedList queue= new LinkedList();
        enqueue(args[0], queue);
        BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter(dataGrid, queue);
        try{ brainfuckInterpreter.run();} catch(UnexpectedCharacterException e) { e.printStackTrace(); }
    }
}