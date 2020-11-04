import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Testing implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;

	public Testing(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Testing call()");
			nextState = taskPool.getNextStateForTesting();
			prevState = taskPool.getPrevStateForTesting();
//			System.out.println("nextState: " + nextState);
//			System.out.println("prevState: " + prevState.getClass().getSimpleName());
//			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingTestingQueue();
				if(task != null){
					action(task);
//					taskPool.addToWaitingDevelopmentQueue(task);
//					continue;
				} else{
					Thread.sleep(3000);
					if(!taskPool.finishJob){
						break;
					}
//					System.out.println("No task to be added to Testing!");
//					break;
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
		System.out.println("Testing Action running..." + task.getTaskId() + '\n');
		return true;
	}
}
