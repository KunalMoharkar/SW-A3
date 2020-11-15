//Assignment 3
//this class contains the main program logic for which test cases have been created
package com.hubberspot.junit5;

import java.util.List;

public class Operations {
	
	enum Coffee{
		ESPRESSO,
		AMERICANO;
	}
	
	public int parse(String s)
	{
		return Integer.parseInt(s);
	}
	
	public void arrayoutofbound(int[] a)
	{
		int n=a.length+1;
		System.out.println("a[length+1]= "+a[n]);
	}
	
	public boolean isPalindrome(String str) 
    { 
  
        // Pointers pointing to the beginning 
        // and the end of the string 
        int i = 0, j = str.length() - 1; 
  
        // While there are characters toc compare 
        while (i < j) { 
  
            // If there is a mismatch 
            if (str.charAt(i) != str.charAt(j)) 
                return false; 
  
            // Increment first pointer and 
            // decrement the other 
            i++; 
            j--; 
        } 
  
        // Given string is a palindrome 
        return true; 
    } 
	
	public boolean isOdd(int n)
	{
		if(n%2!=0) {
			return true;
		}
		return false;
	}
	
	public String returnThisString(String s)
	{
		return s;
	}
	
	public boolean isNullStr(String text)
	{
		return (text == null || text.trim().isEmpty());
	}
	
	public boolean isnotNullCoffee(Coffee coffee)
	{
		return (coffee==Coffee.ESPRESSO || coffee==Coffee.AMERICANO);
	}
	
	public int multiply(int a,int b)
	{
		return a*b;
	}
	
	public boolean MultiArgMethodSource(String str, int num, List<String> list)
	{
		return (str.length()==5 && num >=1 && num <=2 && list.size()==2);
	}
	
	//receives a string pair and returns the concatenated string
		public String concatPair(StringPair p)
		{	
				String str = p.getFirst() + p.getSecond();
				return str;
		}
			
		//receives a string pair and swaps the first with second element
		public void swapPair(StringPair p)
		{
			String first = p.getFirst();
			String second = p.getSecond();
				
			//swap
			p.setFirst(second);
			p.setSecond(first);
		}
}
