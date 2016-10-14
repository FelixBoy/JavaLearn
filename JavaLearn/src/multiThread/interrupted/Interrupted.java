package multiThread.interrupted;

import java.util.concurrent.TimeUnit;

public class Interrupted {
	public static void main(String[] args) throws InterruptedException {
		//sleepThread��ͣ�س���˯��
		Thread sleepThread = new Thread(new SleepRunner(), "Sleep-Thread");
		sleepThread.setDaemon(true);
		//busyThread��ͣ�س�������
		Thread busyThread = new Thread(new BusyRunner(), "Busy-Thread");
		busyThread.setDaemon(true);
		
		sleepThread.start();
		busyThread.start();
		
		//���߳� �������룬�����������̣߳��������
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("SleepThread is intterupted == " + sleepThread.isInterrupted());
		System.out.println("BusyThread is intterupted == " + busyThread.isInterrupted());
		
		TimeUnit.SECONDS.sleep(2);
	}
	static class SleepRunner implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	static class BusyRunner implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				
			}
		}
		
	}
}
