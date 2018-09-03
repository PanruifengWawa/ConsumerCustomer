package version.lock;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	
	private Queue<String> queue;
	private String name;
	private int maxSize;
	private int i = 0;
	public Producer(Queue<String> queue, String name, int maxSize) {
		super();
		this.queue = queue;
		this.name = name;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {
		while(true) {
			
			try {
				Main.lock.lock();
				while(queue.size() == maxSize) {
					System.out.println("xqueue is full, producer: " + name + " waits");
					Main.full.await();
				}
				
				System.out.println("xqueue is not full, producer: " + name + " produces " + i);
				queue.add(name + "-" + (i++));
				
				Main.empty.signalAll();
//				Main.full.signalAll();
				
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
