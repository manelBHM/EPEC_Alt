
public class TestRunnable {

	public static void main(String[] args) throws InterruptedException {

   Runnable runnableLamda = ()->{
	 for ( int i=0; i<3; i++) {
		 System.out.println("hello world from thread ["+Thread.currentThread().getName()+"]");
	 }
   };
Thread t = new Thread(runnableLamda);
t.start();
t.join();
	}

}
