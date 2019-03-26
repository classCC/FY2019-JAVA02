package com.neuedu;

import java.io.File;
import java.io.IOException;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p=new Person();
		String name=p.getName();
		System.out.print(name);
		
		int[]a=new int[5];
		System.out.print(a[5]);
		
	
		
		try {
			File file=new File("aaa");
			file.createNewFile();
		}catch(IOException ex) {
			System.out.println("");
		}
	}

}
