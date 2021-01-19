package Main;

public class Producer extends Thread {
	static TaskManager taskManager;
	
	public Producer(TaskManager taskManager) {
		this.taskManager=taskManager;
	}
	
	public void run() {
		taskManager.write(1L);
		try {
			wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
