package com.seniorglez.brainfuck;

import java.util.LinkedList;

import com.seniorglez.brainfuck.exceptions.UnexpectedCharacterException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Unit test for simple App.
 */
public class BrainfuckInterpreterTest
{
	@Test
	@DisplayName("shouldPrintHelloWorld")
	void smokeTest() throws UnexpectedCharacterException {
		DataGrid dataGrid = new DataGrid();
		LinkedList queue= new LinkedList();
		InputStream input = this.getClass().getResourceAsStream("helloworld.bf");
		BrainfuckInterpreter.enqueue(input, queue);//Should return Hello world!
        BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter(dataGrid, queue);
        brainfuckInterpreter.run();
	}
}