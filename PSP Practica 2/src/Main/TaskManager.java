package Main;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

	List<Long> taskIds;
	int maxSize;

	public List<Long> getList() {
		return taskIds;
	}

	public void setList(List<Long> list) {
		this.taskIds = list;
	}

	public TaskManager(int size) {
		this.taskIds = new ArrayList<Long>(size);
		maxSize = size;
	}

	public synchronized long consumeTask(int id) {
		long extractedTask = -1;

		
		 while(taskIds.isEmpty()) { 
		 try {
		 System.out.printf("Consumer [%02d] >>> wait\n", id);
		 notify();
		 wait();
		 System.out.printf("Consumer [%02d] >>> wake up\n", id); 
		 } catch
		 (InterruptedException e) { // TODO Auto-generated catch block
		 e.printStackTrace(); } }
		 
		extractedTask = taskIds.remove(0);
		System.out.printf("Consumer [%02d] >>> consumes: %02d\n", id, extractedTask);

		// notify();
		return extractedTask;
	}

	public synchronized void produceTask(Long data, int id) {
		while (taskIds.size()==maxSize) {
			try {
				System.out.printf("Consumer [%02d] >>> wait\n", id);
				notify();
				wait();
				System.out.printf("Consumer [%02d] >>> wake up\n", id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public synchronized Long extract() {
		return taskIds.remove(0);
	}

	public synchronized void write(Long data) {
		if (taskIds.size() < maxSize)
			;
		taskIds.add(data);
	}

	
}
