package multiThread.Timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//利用Thread的sleep方法，可以实现简单的定时器效果。
//利用Timer和TimerTask实现的话，Thread的sleep方法实现，具有以下好处
// 1 当启动和取消 任务时，可以控制
// 2 第一次执行任务时，可以指定你想要delay的时间

//在实现时，Timer类实现定时调度任务，TimerTask则是通过在run方法里实现具体任务。
//Timer实例，可以实现调度多任务，而且是 线程安全的。

//当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度TimerTask任务。
public class TimerByTimerTask {
	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("do Some Shecdule Task");
			}
		};
		Timer timer = new Timer();
		
		long delay = 1 * 1000;
		long intervalPeriod = 1 * 1000;
		//在一个固定的频率定时执行任务。
		timer.scheduleAtFixedRate(task, delay, intervalPeriod);
		test3();
	}
	 //3:交替再生：任务2秒4秒交替的执行(无限执行)，  
    static int count = 0;  
    public static void test3() {  
  
        class MyTimerTask extends TimerTask {  
            @Override  
            public void run() {  
                count = (count + 1) % 2;  
                DateFormat format = new SimpleDateFormat("HH:mm:ss");
                System.out.println("bombing at !" + format.format(new Date()));  
                new Timer().schedule(new MyTimerTask(), 2000 + count * 2000);  
            }  
        }  
        new Timer().schedule(new MyTimerTask(), 2000);  
    }  
}
