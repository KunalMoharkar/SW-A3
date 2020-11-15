package com.hubberspot.junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.mypackage.src.Operations;

class ParameterizedTests {

	Operations newobj=new Operations();
	enum Coffee{
		ESPRESSO,
		AMERICANO;
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
