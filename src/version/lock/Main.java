package version.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

	public static ReentrantLock lock = new ReentrantLock();
	public static Condition full = lock.newCondition();
	public static Condition empty = lock.newCondition();
	
	
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		int maxSize = 5;
		new Thread(new Producer(queue, "p1", maxSize)).start();
		new Thread(new Producer(queue, "p2", maxSize)).start();
		
		new Thread(new Consumer(queue, "c1")).start();
		new Thread(new Consumer(queue, "c2")).start();
		new Thread(new Consumer(queue, "c3")).start();
	}
}
