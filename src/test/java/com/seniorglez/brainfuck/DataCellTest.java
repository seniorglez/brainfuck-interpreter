package com.seniorglez.brainfuck;

import com.seniorglez.brainfuck.exceptions.*;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Unit test for simple App.
 */
public class DataCellTest
{
	@Test
	@DisplayName("addsTwoNumbers")
	void testSetMaxAcceptedValue() throws UnsupportedValueException {
        DataCell dataCell = new DataCell();
        dataCell.setValue('ÿ');
    }
    
    @Test
	void testSetMinAcceptedValue() throws UnsupportedValueException {
        DataCell dataCell = new DataCell();
        dataCell.setValue(' ');
    }
    
    @Test
	void testExpectedUnsupportedValueException() {
        Assertions.assertThrows(UnsupportedValueException.class, () -> {
            DataCell dataCell = new DataCell();
            char mander = 266;
            dataCell.setValue(mander);
          });
	}
}