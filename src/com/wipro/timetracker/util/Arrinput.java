package com.wipro.timetracker.util;

import java.io.CharArrayReader;
import java.io.IOException;

public class Arrinput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String object = "abcdefgh";
		int objlen= object.length();
		char c[] = new char[objlen];
		object.getChars(0, objlen, c, 0);
		CharArrayReader input1 = new CharArrayReader(c);
		CharArrayReader input2 = new CharArrayReader(c,1,4);
		
		int i;
		int j;
		 try{
			 while((i=input1.read())==(j=input2.read())){
				 System.out.println((char)i);
			 }
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		
		// int num = (int) 50.05L;
		 byte x = (byte) 50L;
		 long y = (byte) 50;
		 byte z = (byte) 50L;
		
	}

}
