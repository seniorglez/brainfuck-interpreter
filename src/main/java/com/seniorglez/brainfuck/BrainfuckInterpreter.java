package com.seniorglez.brainfuck;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.seniorglez.brainfuck.consumer.Consumer;

/**
 * Hello world!
 *
 */
public class BrainfuckInterpreter
{

    private static void interpret(InputStream inputStream, ConcurrentLinkedQueue concurrentLinkedQueue) 
    {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                interpret(line, concurrentLinkedQueue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void interpret(String line, ConcurrentLinkedQueue concurrentLinkedQueue) 
    {
        IntStream intStream = line.chars();
        concurrentLinkedQueue.addAll(intStream.boxed().collect(Collectors.toList())); //boxed turns the int Stream into a Integer Stream which is collected into a List
    }

    public static void main( String[] args )
    {
        DataGrid dataGrid = new DataGrid();
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Thread thread =new Consumer(concurrentLinkedQueue, dataGrid);
        interpret(args[0], concurrentLinkedQueue);
        thread.start();
    }    
}