
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
	synchronized public String call() {
		try {
			System.out.println("Development call()");
			int randomTime =  rd.nextInt(7000);
			System.out.println("Dev will sleep " + randomTime + "ms before setting todoVar");
			Thread.sleep(randomTime);
			this.taskPool.setToDoVar(2);
			System.out.println("Development set toDoVar to 2");
//			while(true){
				Task task = taskPool.getFromWaitingDevelopmentQueue();
					action(task);
//			}
		} catch(Exception e) {
			System.out.println("Error");
			// TODO Auto-generated method stub
		}
		return null;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Development Action running...");
		Thread.sleep(1000);
//		System.out.println("is mai paralel ca doua linii curve");

		return true;
	}


}
