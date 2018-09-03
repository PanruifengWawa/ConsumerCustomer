package version.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class Main {

	public static void main(String[] args) {
		int maxSize = 5;
		BlockingQueue<String> queue = new LinkedBlockingQueue<>(maxSize);
		new Thread(new Producer(queue, "p1")).start();
		new Thread(new Producer(queue, "p2")).start();
		
		new Thread(new Consumer(queue, "c1")).start();
		new Thread(new Consumer(queue, "c2")).start();
		new Thread(new Consumer(queue, "c3")).start();
	}
}
