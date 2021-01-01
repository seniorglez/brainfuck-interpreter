package com.seniorglez.brainfuck;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Unit test for simple App.
 */
public class BrainfuckInterpreterTest
{
	@Test
	@DisplayName("shouldReturn2")
	void smokeTestA() {
		DataGrid dataGrid = new DataGrid();
		LinkedList queue= new LinkedList();
		//BrainfuckInterpreter.enqueue("++++++++++++++++++++++++++++++++++++++++++++++++++[-.]", queue);//This should print 2
		BrainfuckInterpreter.enqueue("++++[>++++++++++<-]>.", queue);//Should return (
		//BrainfuckInterpreter.enqueue("++++++++++++++++++++++++++++++++++++++++++++++++++.", queue);//This should print 2
		//BrainfuckInterpreter.enqueue("++++++++++[->+++++<].", queue);//This should print 2
		//BrainfuckInterpreter.enqueue("[-]", queue);
        BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter(dataGrid, queue);
        brainfuckInterpreter.run();
	}
}