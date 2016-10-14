package multiThread.Timer;

//ʹ����ͨ��Threadʵ�ֶ�ʱ�����õ�ǰ�̣߳�ÿ��һ��ʱ�䣬��һ����

//����һ���̣߳���run�����У�while��true����һ�����飬����sleep�����ﵽ��ʱ����Ч����
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
