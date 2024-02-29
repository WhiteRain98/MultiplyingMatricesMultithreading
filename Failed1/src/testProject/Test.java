package testProject;

import java.util.ArrayList;
import java.util.List;

//import take2.WorkerThread;



public class Test {
	public static void main(String[] args) throws InterruptedException {
		
		List<Thread> threads = new ArrayList<Thread>();
		Thread thread = null;
		for (int i = 0; i < 5; i++) {
	    	thread = new Thread(new TestThread());
	    	thread.start();
	    	threads.add(thread);
	    	//Thread myThread = new Thread();
		}
		System.out.println(threads);
		System.out.println(threads.get(0));
//		for (thread : threads) {
//			  thread.join();
//		}		
	}
}
