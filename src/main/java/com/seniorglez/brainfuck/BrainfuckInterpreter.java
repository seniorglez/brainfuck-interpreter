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

/**
 * Hello world!
 *
 */
public class BrainfuckInterpreter
{
        private DataGrid dataGrid;
        private LinkedList queue;
        private int position = -1;

    public BrainfuckInterpreter(DataGrid dataGrid, LinkedList queue)
    {
        this.dataGrid = dataGrid;
        this.queue = queue;
    }

    public void run()
    {
        while(nextChar()) consumeChar(getCurrentChar(), dataGrid);
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



    private void consumeChar(int c, DataGrid dataGrid) {
        consumeChar(c,dataGrid, false);
    }

    private void consumeChar(int c, DataGrid dataGrid, boolean loop) {
        
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
                System.out.println(dataGrid.getCurrentValue());
                break;
            case 60://<
                dataGrid.decrementPoiner();
                break;
            case 62://>
                dataGrid.incrementValue();
                break;
            case 91://[
                //recursivity here
                if(dataGrid.getCurrentValue() != 0) {
                    LinkedList queue= new LinkedList();
                    while (getCurrentChar()!= 93) queue.push(Integer.valueOf(getCurrentChar()));
                    BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter(dataGrid,queue);
                    while (dataGrid.getCurrentValue() != 0) {
                        brainfuckInterpreter.run();
                        brainfuckInterpreter.reset();
                    }
                }
                break;
            case 93://]
                System.out.println("Fin bucle");
                break;
            default:
                System.out.println("Wtf is this > " + (char)c);
        }
    }

    private void reset() {
        this.position = -1;
    }

    private boolean nextChar() 
    {
        if(++position < queue.size()) {
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
        int ch = getCurrentChar();
        nextChar();
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
        brainfuckInterpreter.run();
    }    
}