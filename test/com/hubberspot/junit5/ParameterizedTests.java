package com.hubberspot.junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTests {

	Operations newobj=new Operations();
	
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromesTest(String candidate) {
		System.out.println("@ValueSource arg="+candidate);
	    assertTrue(newobj.isPalindrome(candidate));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void nullEmptyAndBlankStringsTest(String text) {
		System.out.println("@NullAndEmptySource arg="+text);
	    assertTrue(newobj.isNullStr(text));
	}
	
	@ParameterizedTest
	@EnumSource(Operations.Coffee.class)
	void nonNullCoffeeTest(Operations.Coffee coffee)
	{
		System.out.println("@EnumSource arg="+coffee);
		assertTrue(newobj.isnotNullCoffee(coffee));
	}
	
	@ParameterizedTest
	@CsvSource({
			"5, 3, 15",
			"2, 3, 6"
	})
	void multiplyTest(int a,int b,int c)
	{
		System.out.println("@CsvSource arg: a="+a+",b="+b+",multiplication result="+c);
		assertEquals(newobj.multiply(a, b),c);
	}
	
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")			//for complex arguments
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
    	System.out.println("@MethodSource arg: string="+str+" number="+num+" list="+list);
    	assertTrue(newobj.MultiArgMethodSource(str, num, list));
    }
    
    static Stream<Arguments> stringIntAndListProvider() {	//factory method that creates the method parameters of the testWithMultiArgMethodSource() method
        return Stream.of(
        		Arguments.of("apple", 1, Arrays.asList("a", "b")),
        		Arguments.of("lemon", 2, Arrays.asList("x", "y"))
        );
    }
}
