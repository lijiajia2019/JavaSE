package 并发;
//synchronized锁住同步代码块,可以用instance、this、.class文件。
//.class是直接同步，无论几个对象。this则是在同一个对象的时候同步。
class TestSyn5 implements Runnable{
static TestSyn instance=new TestSyn();
	static int i;
	@Override
	public void run() {
	
		synchronized(TestSyn5.class)
		{
			for(int j=0;j<1000;j++)
			{
				i++;
			}
		}
	}
	
}


public class Demo01 {
	public static void main(String[] args)  throws Exception{
		TestSyn5 t=new TestSyn5();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(TestSyn5.i);
	}
}
