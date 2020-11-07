package com.mypackage.src;

public class Operations {
	
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
  
        // While there are characters to compare 
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
