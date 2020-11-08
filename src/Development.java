
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
			System.out.println("Development call()");
			int randomTime =  rd.nextInt(7000);
			System.out.println("Dev will sleep " + randomTime + "ms before setting todoVar");
			Thread.sleep(randomTime);
			this.taskPool.setToDoVar(2);


				Task task = taskPool.getFromWaitingDevelopmentQueue();
					action(task);

//
//					this.taskPool.(1);
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
