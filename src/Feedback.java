import java.awt.*;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

public class Feedback implements State {

	TaskPool taskPool;
	Random rd = new Random();
	State testing;
	ExecutorService executorService;

	public Feedback(TaskPool taskPool) {

		this.taskPool = taskPool;
		this.testing = new Testing(taskPool);
		this.executorService = Executors.newFixedThreadPool(1);
	}

	@Override
	synchronized public Integer call() {
		try {
			System.out.println("Feedback call()");
			int randomTime =  rd.nextInt(7000);
			System.out.println("Feedback will sleep " + randomTime + "ms before reading todoVar");
			Thread.sleep(randomTime);


			if(taskPool.getToDoVar() == 2){
				System.out.println("Feedback is alive");
				this.taskPool.setToDoVar(3);

				Task task = taskPool.getFromWaitingFeedbackQueue();
				action(task);
				taskPool.addToWaitingTestingQueue(task);

				Future<Integer> returnValue = executorService.submit(testing);
			}
			else {
				System.out.println("feedback is dead");
				return 1;
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error from Feedback");
			// TODO Auto-generated method stub
		}
		return 0;
	}

	public boolean action(Task task) throws InterruptedException {
		System.out.println("Feedback Action running on task " + task.getTaskId());
		return true;
	}
}

