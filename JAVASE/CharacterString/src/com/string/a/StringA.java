package com.string.a;

import java.util.Scanner;

public class StringA {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=new String();
		System.out.println("请输入:");
		s=sc.nextLine();
		StringA string=new StringA();
		string.count(s);
	}

	/**
	 * 大写英文字母数，小写英文字母数以及非英文字母数
	 * */
	void count(String s)
	{
		int n=s.length();
		char[] a=s.toCharArray();
		int up=0,low=0,space=0,other=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]>='A'&&a[i]<='Z')
				up++;
			else if(a[i]>='a'&&a[i]<='z')
				low++;
			else if(a[i]==' ')
				space++;
			else 
				other++;
		}
		System.out.println("LowerCases:"+low+" UpperCases:"+up+" Spaces:"+space+" Others:"+other);
	}

	
		
	
	
}
