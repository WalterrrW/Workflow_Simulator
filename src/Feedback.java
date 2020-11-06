import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Feedback implements State {

	TaskPool taskPool;
	Random rd = new Random();

	public Feedback(TaskPool taskPool) {
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Feedback call()");

			while (true) {
				Task task = taskPool.getFromWaitingFeedbackQueue();
					action(task);
						taskPool.addToWaitingTestingQueue(task);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error");
			// TODO Auto-generated method stub
		}
		return null;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Feedback Action completed..." + task.getTaskId() + '\n');
		Thread.sleep(3000);
		System.out.println("is mai paralel ca doua linii paralele");
		return true;
	}
}

