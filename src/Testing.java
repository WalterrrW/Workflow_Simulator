import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Testing implements State{

	TaskPool taskPool;
	Random rd = new Random();

	public Testing(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public Integer call() {
		try {
			System.out.println("Testing call()");
			if(taskPool.getToDoVar() == 3){
				System.out.println("Task finished from Testing");
			} else {
				System.out.println("test failed");
			}
		} catch(Exception e) {
			System.out.println("Error");
			// TODO Auto-generated method stub
			return 1;
		}
		return 0;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(2000);
		if(rd.nextBoolean()){
			System.out.println("Testing Action completed...");
			return true;
		}
		System.out.println("Testing Action failed... AICI"+ '\n');
		return false;
	}
}
