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
			System.out.println(nextState.getClass().getSimpleName());
			System.out.println(prevState.getClass().getSimpleName());
			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingFeedbackQueue();
				if(task != null){
					action();
					taskPool.addToWaitingTestingQueue(task);
//					continue;
				} else{
					Thread.sleep(10000);
					System.out.println("No task to be added to Feedback!");
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("Error");
			// TODO Auto-generated method stub
			return null;
		}
		return null;
	}

	public boolean action() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Feedback Action running...\n");
		return true;
	}
}
