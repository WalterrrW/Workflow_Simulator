import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class AddTask implements State{

	TaskPool taskPool;

	public AddTask(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public Integer call() {
		try {
			System.out.println("AddTask call()");

				Task task = taskPool.getFromWaitingAddedTasksQueue();
				if(task != null){
					action(task);
					taskPool.addToWaitingTodosQueue(task);
				} else{
					Thread.sleep(1000);
					System.out.println("AddTask break");
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
		System.out.println("AddTask Action running...");
		return true;
	}
}
