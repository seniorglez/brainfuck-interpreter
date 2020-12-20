package com.seniorglez.brainfuck.consumer;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.sound.sampled.Line;

import com.seniorglez.brainfuck.DataGrid;

public class Consumer extends Thread {

    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;
    private DataGrid dataGrid;

    public Consumer(ConcurrentLinkedQueue concurrentLinkedQueue, DataGrid dataGrid) {
        this.concurrentLinkedQueue = concurrentLinkedQueue;
        this.dataGrid = dataGrid;
    }

    private consumeChar(int c, DataGrid dataGrid) {
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
                ArrayList<Integer> arrayList = new ArrayList<>();
                while(concurrentLinkedQueue.peek()!= ']') arrayList.add(Integer.valueOf(concurrentLinkedQueue.poll()));
                //recursivity here
                break;
            case 93://]
                System.out.println("Fin bucle");
                break;
            default:
                System.out.println("Wtf is this > " + (char)c);
        }
    }

    public void run() {
        while(!isInterrupted()) {
            while(!this.concurrentLinkedQueue.isEmpty()) {
                Integer integer = this.concurrentLinkedQueue.poll();
                consumeChar(integer, this.dataGrid);
            }
        }
    }
}