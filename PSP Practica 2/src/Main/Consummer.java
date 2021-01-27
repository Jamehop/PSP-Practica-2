package Main;

public class Consummer extends Thread{
	static TaskManager taskManager;
	int id;
	int numLoops;
	
	
	
	public Consummer(int id, TaskManager taskManager, int numLoops) {
		this.taskManager=taskManager;
		this.id = id;
		this.numLoops = numLoops;
	}



	public void run() {
		int data= taskManager.consumeTask(id);
		System.out.println("Consumer [" + this.id + "] >>> consumes: " + data);
	}
}
