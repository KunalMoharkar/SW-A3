package com.hubberspot.junit5;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mypackage.src.Operations;
import com.mypackage.src.StringPair;

class Hooks {
	
	static Operations operate;
	StringPair p;
	
	
	//create a insatnce of Operations before stating tests
	//one time initialization
	@BeforeAll
	static void initOperate()
	{	
		System.out.println("only Before All the tests....");
		operate = new Operations();
	}
	
    //Create new instance of StringPair Before each test
	//methods can modify this object so intialize before each test
    @BeforeEach
    void initStringPair()
    { 	
    	
    	System.out.println("once Before each test....");
    	p = new StringPair("kunal","suruchi");
    }
    
    //cleaning up after all tests completed
    @AfterAll
    static void cleanOperate()
    {  
       //clear reference of operate after all the tests done
       operate = null;
       System.out.println("only After all the tests....");
    }
    
    
    //cleaning up after each test
    @AfterEach
    void cleanStringPair()
    {	
    	//clearing refrences of String pair after each test
    	p = null;
    	System.out.println("once After each test....");
    }
	
    //test ConcatPair method
	@Test
	void testConcatPair()
	{	
		System.out.println("test concatPair");
		String exp = new String("kunalsuruchi");
		String act = operate.concatPair(p);
		
		//if equal the pass then test
		assertEquals(exp,act);
	}
	
	//test Swap pair method
	@Test
	void testSwapPair()
	{
		System.out.println("test SwapPair");
		String[] exp = {"suruchi", "kunal"};
		operate.swapPair(p);
		
		//act = {"suruchi","kunal"}
		String[] act =  {p.getFirst(),p.getSecond()};

		//if equal the pass then test
		assertArrayEquals(exp, act);
	
	}
	
	
}
