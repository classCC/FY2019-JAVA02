package com.string;

public class StringO {

	public static void main(String[] args) {
		String s1="asdfg";
		String s2="abcde";
		
		System.out.println(s1.charAt(0));		//索引。第0个字符是什么
		System.out.println(s1.concat(s2));		//将指定字符串连接到此字符串的结尾。s1+s2
		System.out.println(s1.getBytes());		//
		System.out.println(s1.indexOf('d'));	//返回指定子字符串在此字符串中第一次出现处的索引
		System.out.println(s1.lastIndexOf('d'));//返回指定字符在此字符串中最后一次出现处的索引
		System.out.println(s1.length());		//返回此字符串的长度
		System.out.println(s1.replace('s','x'));//s换成x
		System.out.println(s1.substring(1,4));	//返回一个新的字符串，它是此字符串的一个子字符串
		
		String s3="a-b-c";
		String[] ss=s3.split("-");				//按-拆分
		for(int i=0;i<ss.length;i++) {
			System.out.println(ss[i]);
		}
		
		//stringbuffer的用法
		StringBuffer buffer=new StringBuffer("qwer");
		buffer.append("zxc");
		
		System.out.println(buffer);
	}
}
