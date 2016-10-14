package multiThread.Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//ScheduledExecutorService�Ǵ�Java SE 5��Java.util.concurrent���Ϊ�������߱�������
//����������Ķ�ʱ����ʵ�ַ�ʽ�����ǰ���֣����������ŵ�
//1 ����ʵ�� �ӳ�һ��ʱ����ٿ�ʼִ�С�
//2 ���Timer�ĵ��̣߳�����ͨ���̳߳صķ�ʽ��ִ�ж�ʱ�����
//3 �ṩ�˸����õ�ʱ��Լ����ʽ��ֱ�۷������ʱ��
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
