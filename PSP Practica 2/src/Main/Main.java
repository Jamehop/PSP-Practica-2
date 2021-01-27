package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static TaskManager taskManager;
	static final int NUM_CONSUMERS = 100;
	static final int NUM_PRODUCERS = 100;
	static final int LOOPS=100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TaskManager taskManager = new TaskManager(20);
		List<Consummer> consummers = new ArrayList<>();
		List<Producer> producers = new ArrayList<>();
		for (int i = 0; i < NUM_CONSUMERS; i++) {
			consummers.add(new Consummer(i, taskManager, LOOPS));
		}
		for (int i = 0; i < NUM_PRODUCERS; i++) {
			producers.add(new Producer(i, taskManager, LOOPS));
		}

		for (Consummer c : consummers) {
			c.start();
		}
		for (Producer p : producers) {
			p.start();
		}
		//join bloquea el subproceso hasta que los hilos finalizan su proceso
		for (Consummer c : consummers) {
			try { 
				c.join(); 
				}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		for (Producer p : producers) {
			try {
				p.join(); 
				}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		System.out.println("Tareas restantes: " + taskManager.listaTareas.size());
		System.out.println("THE END");
	}
}
