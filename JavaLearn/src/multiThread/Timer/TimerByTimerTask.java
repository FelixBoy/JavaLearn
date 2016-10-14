package multiThread.Timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//����Thread��sleep����������ʵ�ּ򵥵Ķ�ʱ��Ч����
//����Timer��TimerTaskʵ�ֵĻ���Thread��sleep����ʵ�֣��������ºô�
// 1 ��������ȡ�� ����ʱ�����Կ���
// 2 ��һ��ִ������ʱ������ָ������Ҫdelay��ʱ��

//��ʵ��ʱ��Timer��ʵ�ֶ�ʱ��������TimerTask����ͨ����run������ʵ�־�������
//Timerʵ��������ʵ�ֵ��ȶ����񣬶����� �̰߳�ȫ�ġ�

//��Timer�Ĺ�����������ʱ����������һ���̣߳�����߳̿�����������TimerTask����
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
		//��һ���̶���Ƶ�ʶ�ʱִ������
		timer.scheduleAtFixedRate(task, delay, intervalPeriod);
		test3();
	}
	 //3:��������������2��4�뽻���ִ��(����ִ��)��  
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
