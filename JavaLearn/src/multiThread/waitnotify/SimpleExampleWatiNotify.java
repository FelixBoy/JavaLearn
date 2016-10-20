package multiThread.waitnotify;

public class SimpleExampleWatiNotify {
	//用 wait和notify 实现 线程间的 通信
	public static void main(String[]args)throws Exception {
	    final Object obj = new Object();
	    
	    Thread t1 = new Thread() {
	        public void run() {
	            synchronized (obj) {
	            	while(true){
	                try {
	                	System.out.println("Thread 1 wake up.");
	                    obj.wait();
	                    obj.notify();
	                } catch (InterruptedException e) {
	                	e.printStackTrace();
	                }
	            	}
	            }
	        }
	    };
	    t1.start();
	    Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
	    Thread t2 = new Thread() {
	        public void run() {
	            synchronized (obj) {
	            	while(true){
	            		try {
	            			obj.notify();
							Thread.sleep(2000);
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}
	            }
	        }
	    };
	    t2.start();
	}
}
