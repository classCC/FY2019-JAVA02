package com.string.b;

public class TestThread extends Thread {

	private int num;
	public static void main(String[]args) {
		
		Thread thread=new TestThread();
		thread.start();
		
		for(int i=0;i<600;i++) {
			System.out.println("=====main()====="+i);
		}
	}
	public TestThread() {
		
	}
	public TestThread(int num) {
		this.num =num;
	}
	public void run() throws InterruptedException {
		
		for(int i=0;i<600;i++) {
			System.out.println("===run()==="+i);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
			
		}
		
	}
	
}
