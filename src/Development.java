import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Development implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;
	Scanner sc = new Scanner(System.in);

	public Development(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Development call()");

			while(true){
				Task task = taskPool.getFromWaitingDevelopmentQueue();
					action(task);
			}
		} catch(Exception e) {
			System.out.println("Error");
			// TODO Auto-generated method stub
		}
		return null;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Development Action running..." + '\n');
		Thread.sleep(1000);
		System.out.println("is mai paralel ca doua linii paralele");

		return true;
	}


}
