package multiThread.Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//ScheduledExecutorService是从Java SE 5的Java.util.concurrent里，做为并发工具被引进的
//这是最理想的定时任务实现方式，相比前两种，具有以下优点
//1 可以实现 延迟一段时间后，再开始执行。
//2 相比Timer的单线程，它是通过线程池的方式来执行定时任务的
//3 提供了更良好的时间约定方式。直观方便控制时间
public class TimerByScheduledExecutorService {
	public static void main(String[] args) {
		Runnable runnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("do some Schedule Task");
			}
			
		};
		
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();
		
		service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
	}
}
