package chapter16.thread;

import java.awt.Toolkit;

public class MyThread4 implements Runnable {

	@Override
	public void run() {
		System.out.println("t1 : "+Thread.currentThread().getName());
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
