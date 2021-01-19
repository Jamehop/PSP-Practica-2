package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static TaskManager taskManager;
	static final int NUM_CONSUMERS = 100;
	static final int NUM_PRODUCERS = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TaskManager taskManager = new TaskManager(20);
		List<Consummer> consummers = new ArrayList<>();
		List<Producer> producers = new ArrayList<>();
		for (int i = 0; i < NUM_CONSUMERS; i++) {
			consummers.add(new Consummer(taskManager));
		}
		for (int i = 0; i < NUM_PRODUCERS; i++) {
			producers.add(new Producer(taskManager));
		}

		for (Consummer c : consummers) {
			c.start();
		}
		for (Producer p : producers) {
			p.start();
		}
	}
}
