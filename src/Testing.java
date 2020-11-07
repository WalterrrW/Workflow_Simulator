import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Testing implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;
	Random rd = new Random();

	public Testing(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Testing call()");
			Thread.sleep(20000);
			if(taskPool.getToDoVar() == 3){
				System.out.println("Task finished from Testing");
			} else {
				System.out.println("test failed");
			}
		} catch(Exception e) {
			System.out.println("Error");
			// TODO Auto-generated method stub
			return null;
		}
		return null;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(2000);
//		System.out.println("Testing Action running..." + task.getTaskId() + '\n');
		if(rd.nextBoolean()){
			System.out.println("Testing Action completed...");
			return true;
		}
		System.out.println("Testing Action failed... AICI"+ '\n');
		return false;
	}
}
