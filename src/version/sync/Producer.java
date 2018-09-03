package version.sync;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	private String name;
	
	private Queue<String> queue;
	
	private int maxSize;
	private int i = 0;

	
	
	
	public Producer(String name, Queue<String> queue, int maxSize) {
		super();
		this.name = name;
		this.queue = queue;
		this.maxSize = maxSize;
	}




	@Override
	public void run() {
		while(true) {
			
			synchronized (queue) {
				while(queue.size() == maxSize) {
					System.out.println("queue is full, producer: " + name + " waits");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("queue is not full, producer: " + name + " produces " + i);
				queue.add(name + "-" + (i++));
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
