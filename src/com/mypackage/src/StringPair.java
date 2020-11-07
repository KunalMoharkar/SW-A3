package com.mypackage.src;

//this class allows us to declare a object having pair of strings

public class StringPair {
	
	//data members
	private String a;
	private String b;
	
	//functions
	
	//constructors
	public StringPair() {}
	
	public StringPair(String a,String b)
	{
		this.a = a;
		this.b = b;
	}
	
	//getters
    public String getFirst()
    {
 		
		return this.a;
	}
	
	

	public String getSecond()
	{
		return this.b;
	}
	
	//setters
	public void setFirst(String a)
	{
		this.a = a;
	}
	
	public void setSecond(String b)
	{
		this.b = b;
	}

	
}
