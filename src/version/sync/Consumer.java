package version.sync;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable {
	
	private String name;
	
	private Queue<String> queue;

	public Consumer(String name, Queue<String> queue) {
		super();
		this.name = name;
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.isEmpty()) {
					System.out.println("queue is empty, consumer: " + name + " waits");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("queue is not empty, conusmer: " + name + " consumes " + queue.poll());
				queue.notifyAll();
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
