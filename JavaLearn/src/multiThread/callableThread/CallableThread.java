package multiThread.callableThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1 ����Callable����
		Callable<Integer> callable = new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				int i = 0;
				for(; i < 100; i++){
					System.out.println(Thread.currentThread().getName() + "== "+i);
				}
				return i;
			}
		};
		//�󶨶�Ӧ��future����
		FutureTask<Integer> task = new FutureTask<Integer>(callable);
		//3 �����߳�
		new Thread(task).start();
		
		//��ͣ����֮�󣬻�ȡ����ֵ
		Thread.sleep(5000);
		System.out.println(task.get());
	}
}
