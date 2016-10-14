package multiThread.callableThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1 定义Callable对象
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
		//绑定对应的future对象
		FutureTask<Integer> task = new FutureTask<Integer>(callable);
		//3 启动线程
		new Thread(task).start();
		
		//暂停几秒之后，获取返回值
		Thread.sleep(5000);
		System.out.println(task.get());
	}
}
