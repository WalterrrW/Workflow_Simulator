import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Development implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;

	public Development(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Development call()");
			nextState = taskPool.getNextStateForDevelopment();
			prevState = taskPool.getPrevStateForDevelopment();
//			System.out.println("nextState:" + nextState.getClass().getSimpleName());
//			System.out.println("prevState: " + prevState);
//			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingDevelopmentQueue();
				if(task != null){
					action(task);
					taskPool.addToWaitingFeedbackQueue(task);
//					continue;
				} else{
					Thread.sleep(3000);
					if(!taskPool.finishJob){
						break;
					}
//					System.out.println("No task to be added to Development!");
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
		System.out.println("Development Action running..." + task.getTaskId() + '\n');
		return true;
	}
}
