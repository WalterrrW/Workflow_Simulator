
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
			if(taskPool.getToDoVar() == 1) {
				System.out.println("Dev is alive");
				int randomTime2 =  rd.nextInt(2000);
				System.out.println("Dev will sleep " + randomTime2 + "ms before setting todoVar");
				Thread.sleep(randomTime2);
				this.taskPool.setToDoVar(2);
			} else {
				System.out.println("Development failed because toDoVar is not ser from Todo");
				return 1;
			}

				Task task = taskPool.getFromWaitingDevelopmentQueue();
					action(task);
		} catch(Exception e) {
			System.out.println("Error");
			// TODO Auto-generated method stub
		}
		return 0;
	}

	public boolean action(Task task) throws InterruptedException {
//		Thread.sleep(3000);
		System.out.println("Development Action running...");

		return true;
	}


}
