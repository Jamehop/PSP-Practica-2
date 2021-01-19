package Main;

public class Consummer extends Thread{
	static TaskManager taskManager;
	
	public Consummer(TaskManager taskManager) {
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
