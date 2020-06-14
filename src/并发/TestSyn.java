package 并发;
/*
 * 测试多线程下多线程对同一个对象的同一个方法。
 */
public class TestSyn implements Runnable{
	//共享资源。
	static int i=0;
	
	//synchronized修饰实例方法。
	public synchronized void increase()
	{
		i++;
	}
	
	@Override
	public void run() {
		for(int j=0;j<1000;j++)
		{
			increase();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		TestSyn t=new TestSyn();
		
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
	
	
}


