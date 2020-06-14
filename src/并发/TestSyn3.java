package 并发;
/*
 * 当多个线程执行，有synchronized方法和没有synchronized方法的时候，没有的就可以被其他的线程执行。
 */
public class TestSyn3 {

	synchronized public void method1()
	  {
		  try {
			System.out.println("method1 start");
			  Thread.sleep(1000);
			  System.out.println("method1 end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	 
	public void method2()
	 {
		 try {
			System.out.println("method2 start");
			 Thread.sleep(1000);
			 System.out.println("method2 end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static void main(String[] args) {
		TestSyn3 t=new TestSyn3();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.method1();
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.method2();
				
			}
		}).start();
		
	}
}
