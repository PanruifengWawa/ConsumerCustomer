package version.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue;
	
	private String name;

	public Consumer(BlockingQueue<String> queue, String name) {
		super();
		this.queue = queue;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			
			try {
				System.out.println("consumer " + name + " consumes " + queue.take());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
