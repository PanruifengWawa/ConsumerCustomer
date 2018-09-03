package version.sync;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		int maxSize = 5;
		new Thread(new Producer("p1", queue, maxSize)).start();
		new Thread(new Producer("p2", queue, maxSize)).start();
		
		new Thread(new Consumer("c1", queue)).start();
		new Thread(new Consumer("c2", queue)).start();
		new Thread(new Consumer("c3", queue)).start();
	}
}
