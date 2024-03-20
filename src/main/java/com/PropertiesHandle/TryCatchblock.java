package com.PropertiesHandle;

public class TryCatchblock {

	public static void main(String[] args) {
	    try {
		int no=10/0;
		System.out.println(no);
		System.out.println("Hello");
		System.out.println("Hello");
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

	}

}
