package designPattern;

public class Singleton {  
 	
	private static class SingletonHolder { 
 		private static final Singleton INSTANCE = new Singleton();  
 	}
 	
	private Singleton (){System.out.println("สตภýปฏ");}
	
	public static final Singleton getInstance() {  
	    return SingletonHolder.INSTANCE;  
	}
	
	public static void main(String[] args) {
		System.out.println("");
	}
}