package Main;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

	List<Integer> listaTareas;
	int maxSize;

	public TaskManager(int size) {
		this.listaTareas = new ArrayList<Integer>(size);
		maxSize = size;
	}

	public synchronized int consumeTask(int id) {
		while (listaTareas.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Integer n = listaTareas.remove(0);
		notifyAll();

		return n;
	}

	public synchronized void produceTask(Integer data, int id) {
		while (listaTareas.size() > this.maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		listaTareas.add(data);

		notifyAll();

	}

}
