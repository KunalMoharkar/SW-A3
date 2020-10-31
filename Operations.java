package com.hubberspot.junit5;

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
}
