package multiThread.suspend_rsume_stop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Deprecated {
	public static void main(String[] args) throws InterruptedException {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		Thread printThread = new Thread(new Runner(), "printThread");
		
		printThread.setDaemon(true);
		printThread.start();
		
		TimeUnit.SECONDS.sleep(3);
		//��printThreadֹͣ��������ݹ���ֹͣ
		printThread.suspend();
		System.out.println("main suspended PrintThread at " + format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		//��printThread�ָ���������ݹ����ָ�
		printThread.resume();
		System.out.println("main resume PrintThread at " + format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		//��printThread��ֹ��������ݹ�����ֹ
		printThread.stop();
		System.out.println("main stop PrintThread at " + format.format(new Date()));TimeUnit.SECONDS.sleep(3);
		TimeUnit.SECONDS.sleep(3);
	}
	static class Runner implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			DateFormat format = new SimpleDateFormat("HH:mm:ss");
			while(true){
				System.out.println(Thread.currentThread().getName() + " Run at "
						+ format.format(new Date()));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
