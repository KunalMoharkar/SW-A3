package com.hubberspot.junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestExceptions {

	 Operations newobj=new Operations();
	 @Test
	  public void testArrayBound()
	  {
		   System.out.println("Inside testArrayBound() Q4");
		   int[] a= {1,2,3};
		   Exception exception=assertThrows(RuntimeException.class,()->newobj.arrayoutofbound(a));
		   assertEquals("Index 4 out of bounds for length 3",exception.getMessage());
	  }
	   
	 @Test
	public void test_parse() {
		   System.out.println("Inside test_parse() Q4");
		   Exception exception = assertThrows(NumberFormatException.class, () -> newobj.parse("1a"));
		   String expectedMessage = "For input string";
		   String actualMessage = exception.getMessage();
		 
		   assertTrue(actualMessage.contains(expectedMessage));
	}

}
