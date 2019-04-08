package com.string.c;

public class ErfenFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,3,5,2,4};
		boolean isexists=search(a,6);
		if(isexists) {
			System.out.println("查找");
		}else {
			System.out.println("没有查找");
		}
	}

	public static boolean search(int a[],int n) {
		
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		int x=0;
		int y=a.length-1;
		int k=(x+y)/2;
		
		while(x<=y) {
			if(a[k]>n) {
				y=k-1;
			}else if(a[k]<n) {
				x=k+1;
			}else {
				return true;
			}
			k=(x+y)/2;
		}
		return false;
	}
}







