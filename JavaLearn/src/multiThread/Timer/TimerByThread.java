package multiThread.Timer;

//使用普通的Thread实现定时器，让当前线程，每隔一段时间，做一件事

//创建一个线程，在run方法中，while（true）做一件事情，利用sleep方法达到定时任务效果。
public class TimerByThread {
	public static void main(String[] args){
		final long timeInterval = 1000;
		Runnable runnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					System.out.println("do some Task");
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
