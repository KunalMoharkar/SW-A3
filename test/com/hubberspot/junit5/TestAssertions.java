
package com.hubberspot.junit5;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import com.mypackage.src.*; 

public class TestAssertions {

	Operations newobj=new Operations();
	enum Coffee{
		ESPRESSO,
		AMERICANO;
	}

   @Test
   public void testAssertions() {
	   System.out.println("Inside testAssertions() Q3");
      //test data
      String str1 = new String ("def");
      String str2 = new String ("def");
      String str3 = null;
      String str4 = "abc";
      String str5 = "abc";
		
      int val1 = 5;
      int val2 = 6;

      String[] expectedArray = {"one", "two", "three"};
      String[] resultArray =  {"one", "two", "three"};

      //Check that two objects are equal
      assertEquals(str1, str2);

      //Check that a condition is true
      assertTrue (val1 < val2);

      //Check that a condition is false
      assertFalse(val1 > val2);

      //Check that an object isn't null
      assertNotNull(str1);

      //Check that an object is null
      assertNull(str3);

      //Check if two object references point to the same object
      assertSame(str4,str5);

      //Check if two object references not point to the same object
      assertNotSame(str1,str3);

      //Check whether two arrays are equal to each other.
      assertArrayEquals(expectedArray, resultArray);
   }
   
   @Test
	public void test_parse() {
	   System.out.println("Inside test_parse() Q4");
	    Exception exception = assertThrows(NumberFormatException.class, () -> newobj.parse("1a"));
	    String expectedMessage = "For input string";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
   
   @Test
   public void testArrayBound()
   {
	   System.out.println("Inside testArrayBound() Q4");
	   int[] a= {1,2,3};
	   Exception exception=assertThrows(RuntimeException.class,()->newobj.arrayoutofbound(a));
	   assertEquals("Index 4 out of bounds for length 3",exception.getMessage());
   }
   
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		System.out.println("@ValueSource");
	    assertTrue(newobj.isPalindrome(candidate));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void nullEmptyAndBlankStrings(String text) {
		System.out.println("@NullAndEmptySource");
	    assertTrue(text == null || text.trim().isEmpty());
	}
	
	@ParameterizedTest
	@EnumSource(Coffee.class)
	void nonNullCoffee(Coffee coffee)
	{
		System.out.println("@EnumSource");
		assertNotNull(coffee);
		System.out.println("Coffee is not NULL");
	}
	
	@ParameterizedTest
	@CsvSource({
			"5, 3, 15",
			"2, 3, 6"
	})
	void multiply(int a,int b,int c)
	{
		System.out.println("@CsvSource");
		assertEquals(c, a*b);
	}
	
	@ParameterizedTest
    @MethodSource("sumProvider")
    void sum(int a, int b, int sum) {
		System.out.println("@MethodSource");
        assertEquals(sum, a + b);
    }
 
    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5)
        );
    }
	
}
