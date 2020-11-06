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
//			System.out.println("nextState: " + nextState);
//			System.out.println("prevState: " + prevState.getClass().getSimpleName());
//			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingTestingQueue();
				if(task != null){
					if(action(task)){
						System.out.println(task.getTaskId() + " in production");
					} else {
						taskPool.addToWaitingDevelopmentQueue(task);
					}
				} else{
					Thread.sleep(1000);
					if(!taskPool.finishJob){
						break;
					}
				}
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
			System.out.println("Testing Action completed..." + '\n');
			return true;
		}
		System.out.println("Testing Action failed... AICI"+ '\n');
		return false;
	}
}
