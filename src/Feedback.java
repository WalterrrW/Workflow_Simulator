import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Feedback implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;

	public Feedback(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Feedback call()");
			nextState = taskPool.getNextStateForFeedback();
			prevState = taskPool.getPrevStateForFeedback();
//			System.out.println("nextState: " + nextState.getClass().getSimpleName());
//			System.out.println("prevState: " + prevState.getClass().getSimpleName());
//			System.out.println();
			
			while(true){
				Task task = taskPool.getFromWaitingFeedbackQueue();
				if(task != null){
					action(task);
					taskPool.addToWaitingTestingQueue(task);
				} else{
					Thread.sleep(3000);
					if(!taskPool.finishJob){
						break;
					}
				}
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Error");
			// TODO Auto-generated method stub
			return null;
		}
		return null;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Feedback Action running..." + task.getTaskId() + '\n');
		return true;
	}
}
