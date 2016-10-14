package multiThread.threadState;

import java.util.concurrent.TimeUnit;

public class ThreadState {
	public static void main(String[] args) {
		
		//����֮��ʹ��jstack����鿴�߳�״̬
		
		new Thread(new TimeWaiting(), "TimeWaiting Thread").start();
		new Thread(new Waiting(), "Waiting Thread").start();
		
		//ʹ������Blocked�̣߳�һ����ȡ���ɹ���һ��һֱ������
		new Thread(new Blocked(), "Blocked--1").start();
		new Thread(new Blocked(), "Blocked--2").start();
	}
	
	//���߳�һֱ���ϵ�˯��
	static class TimeWaiting implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				SleepUtils.second(100);
			}
		}
		
	}
	//���߳���Waiting.classʵ���ϵȴ���
	static class Waiting implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized(Waiting.class){
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	//���̲߳�ͣ����Blocked.classʵ���ϼ����󣬲����ͷŸ�����
	static class Blocked implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(Blocked.class){
				while(true){
					SleepUtils.second(100);
				}
			}
		}
		
	}
}
class SleepUtils{
	public static final void second(long seconds){
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}