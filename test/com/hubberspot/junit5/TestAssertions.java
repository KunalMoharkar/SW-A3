//Assignment 3
package com.hubberspot.junit5;

import org.junit.Test;

import com.mypackage.src.Operations;

import static org.junit.Assert.*;

public class TestAssertions {

	Operations newobj=new Operations();
	
   @Test
   public void testAssertions() {
	   System.out.println("Inside testAssertions() Q3");
		
	  //test data
      String[] expectedArray = {"one", "two", "three"};
      String[] resultArray =  {"one", "two", "three"};


      //Check that a condition is true
      assertTrue (newobj.isOdd(3));

      //Check that a condition is false
      assertFalse(newobj.isOdd(4));

      //Check that an object isn't null
      assertNotNull(newobj.returnThisString("abcd"));

      //Check whether two arrays are equal to each other.
      assertArrayEquals(expectedArray, resultArray);
   }
   
   
   
	
}
