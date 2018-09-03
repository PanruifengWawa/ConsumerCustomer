package version.blockingqueue;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<String> queue;
	
	private String name;
	private int i;
	public Producer(BlockingQueue<String> queue, String name) {
		super();
		this.queue = queue;
		this.name = name;
	}
	@Override
	public void run() {
		while(true) {
			
			try {
				queue.put(name + "-" + i);
				System.out.println("producer " + name + " produces " + i);
				i++;
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
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
