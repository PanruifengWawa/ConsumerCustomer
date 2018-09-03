package version.lock;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable {
	private Queue<String> queue;
	private String name;
	
	
	
	public Consumer(Queue<String> queue, String name) {
		super();
		this.queue = queue;
		this.name = name;
	}



	@Override
	public void run() {
		while(true) {
			
			try {
				Main.lock.lock();
				while(queue.isEmpty()) {
					System.out.println("xqueue is empty, consumer: " + name + " waits");
					Main.empty.await();
				}
				
				System.out.println("xqueue is not empty, consumer: " + name + " consumes " + queue.poll());
				
				Main.full.signalAll();
//				Main.empty.signalAll();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Main.lock.unlock();
			}
			
			
			
			
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
