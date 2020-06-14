package 并发;
/*
 * 当synchronized遇上不同的对象。因为两个不同的对象对应不同的锁，所以它们不相并不影响。
 */
public class TestSyn4 implements Runnable{
	//共享资源。
	static int i=0;
	
	//synchronized修饰实例方法。
	public static synchronized void increase()
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
		TestSyn4 test1=new TestSyn4();
		TestSyn test2=new TestSyn();
		Thread t1=new Thread(test1);
		Thread t2=new Thread(test2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
