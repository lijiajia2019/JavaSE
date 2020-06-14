package 并发;
//测试有多个方法synchronize修饰，同一个对象不同的线程的方法的情况。
//测试的方法：看顺序。
//一次要锁住全部，就是这个对象被锁住了，一次只能执行某个被锁住的代码块，其他的都不能被执行。
//可以看出其他线程访问其他的synchronized方法时需要先把锁释放掉。

public class TestSyn2  {
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
 
 synchronized public void method2()
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
	 TestSyn2 t=new TestSyn2();
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
	}).start();;
}
 
 
 
}
