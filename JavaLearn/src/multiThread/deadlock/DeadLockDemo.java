package multiThread.deadlock;

public class DeadLockDemo {
	private static String A = "A";
	private static String B = "B";
	
	public static void main(String[] args){
		new DeadLockDemo().deadlock();
	}
	
	private void deadlock(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(A){
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(B){
						System.out.print("1");
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(B){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(A){
						System.out.print("1");
					}
				}
			}
			
		});
		t1.start();
		t2.start();
	}
}
