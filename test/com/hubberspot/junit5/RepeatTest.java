package com.hubberspot.junit5;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import com.mypackage.src.Operations;
import com.mypackage.src.StringPair;

class RepeatTest {
	
	Operations operate = new Operations();
	
	@RepeatedTest(8)
	void test(RepetitionInfo rep)
	{
		int val = rep.getCurrentRepetition();
		StringPair p;
		
		System.out.println("repition num : "+ val);
		
		//test logic of concat pair for first 4 repetition
		if(val<=4)
		{	
			String exp;
			
			//test for differnt paramerters in each repetition
			switch(val) {
				
				case 1:
					p = new StringPair("kunal","suruchi");
					exp = "kunalsuruchi";
					break;
				case 2:
					p = new StringPair("bat","ball");
					exp = "batball";
					break;
				case 3:
					p = new StringPair("tiger","lion");
					exp = "tigerlion";
					break;
				default:
					p = new StringPair("rome","italy");
					exp = "romeitaly";
					
			}
			
			System.out.println("test concatPair");
			System.out.println("Testing for: {"+ p.getFirst()+","+p.getSecond()+"}");
			
			String act = operate.concatPair(p);
			//if equal the pass then test
			assertEquals(exp,act);
		}
		//test logic of swap pair for last 4 repetition
		else
		{	
			//test for differnt paramerters in each repetition
			switch(val) {
				
				case 5:
					p = new StringPair("kunal","suruchi");
					break;
				case 6:
					p = new StringPair("bat","ball");
					break;
				case 7:
					p = new StringPair("tiger","lion");
					break;
				default:
					p = new StringPair("rome","italy");
					
			}
			System.out.println("test SwapPair");
			System.out.println("Testing for: {"+ p.getFirst()+","+p.getSecond()+"}");
			
			String[] exp = {p.getSecond(), p.getFirst()};
			operate.swapPair(p);	
			String[] act =  {p.getFirst(),p.getSecond()};
			//if equal the pass then test
			assertArrayEquals(exp, act);
		}
		
		
	}

}
