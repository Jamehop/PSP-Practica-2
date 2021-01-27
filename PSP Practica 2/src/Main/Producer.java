package Main;

import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread {
	static TaskManager taskManager;
	int id;
	int numLoops;

	public Producer(int id, TaskManager taskManager, int numLoops) {
		this.taskManager = taskManager;
		this.id = id;
		this.numLoops = numLoops;
	}

	public void run() {
		Integer data = (ThreadLocalRandom.current().nextInt(0, numLoops))+1;
		taskManager.produceTask(data, id);
		System.out.println("Producer [" + this.id + "] >>> produces: " + data);
	}
}
