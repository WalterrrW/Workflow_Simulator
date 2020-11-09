
import java.util.Random;
import java.util.Scanner;


public class Development implements State{

	TaskPool taskPool;
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	public Development(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public Integer call() {
		try {
			System.out.println("Development has been called from Todo, now running...");
			int randomTime =  rd.nextInt(7000);
			System.out.println("Development sleeps for " + randomTime + " ms before setting todoVar");
			Thread.sleep(randomTime);
			this.taskPool.setToDoVar(2);
			//Runtime.getRuntime().exec("cmd /c setx varManagerDev 2");

			Task task = taskPool.getFromWaitingDevelopmentQueue();
			if (task != null){
				action(task);
			}
		} catch(Exception e) {
			System.out.println("Error from Development");
			// TODO Auto-generated method stub
		}
		return 0;
	}

	public boolean action(Task task){
		System.out.println("Development Action running on task " + task.getTaskId());
		return true;
	}


}
