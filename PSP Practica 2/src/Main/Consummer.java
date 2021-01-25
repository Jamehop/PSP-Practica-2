package Main;

public class Consummer extends Thread{
	static TaskManager taskManager;
	int id;
	int numLoops;
	
	
	
	public Consummer(int id, TaskManager taskmanager, int numLoops) {
		this.taskManager=taskManager;
		this.id = id;
		this.numLoops = numLoops;
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
