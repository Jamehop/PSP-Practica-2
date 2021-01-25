package Main;

public class Producer extends Thread {
	static TaskManager taskManager;
	int id;
	int numLoops;
	
	
	
	public Producer(int id, TaskManager taskmanager, int numLoops) {
		this.taskManager=taskManager;
		this.id = id;
		this.numLoops = numLoops;
	}
	
	public void run() {
		for(int i=0; i<numLoops;i++) {
			long taskExtracted=taskManager.produceTask(data, i);
		}
		taskManager.write(1L);
		try {
			wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
