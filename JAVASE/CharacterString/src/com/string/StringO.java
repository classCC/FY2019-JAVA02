package com.string;

public class StringO {

	public static void main(String[] args) {
		String s1="asdfg";
		String s2="abcde";
		
		System.out.println(s1.charAt(0));		//��������0���ַ���ʲô
		System.out.println(s1.concat(s2));		//��ָ���ַ������ӵ����ַ����Ľ�β��s1+s2
		System.out.println(s1.getBytes());		//
		System.out.println(s1.indexOf('d'));	//����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�������
		System.out.println(s1.lastIndexOf('d'));//����ָ���ַ��ڴ��ַ��������һ�γ��ִ�������
		System.out.println(s1.length());		//���ش��ַ����ĳ���
		System.out.println(s1.replace('s','x'));//s����x
		System.out.println(s1.substring(1,4));	//����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ���
		
		String s3="a-b-c";
		String[] ss=s3.split("-");				//��-���
		for(int i=0;i<ss.length;i++) {
			System.out.println(ss[i]);
		}
		
		//stringbuffer���÷�
		StringBuffer buffer=new StringBuffer("qwer");
		buffer.append("zxc");
		
		System.out.println(buffer);
	}
}
