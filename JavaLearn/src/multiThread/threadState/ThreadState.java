package multiThread.threadState;

import java.util.concurrent.TimeUnit;

public class ThreadState {
	public static void main(String[] args) {
		
		//运行之后，使用jstack命令，查看线程状态
		
		new Thread(new TimeWaiting(), "TimeWaiting Thread").start();
		new Thread(new Waiting(), "Waiting Thread").start();
		
		//使用两个Blocked线程，一个获取锁成功，一个一直在阻塞
		new Thread(new Blocked(), "Blocked--1").start();
		new Thread(new Blocked(), "Blocked--2").start();
	}
	
	//该线程一直不断的睡眠
	static class TimeWaiting implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				SleepUtils.second(100);
			}
		}
		
	}
	//该线程在Waiting.class实例上等待。
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
	//该线程不停的在Blocked.class实例上加锁后，不会释放该锁。
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