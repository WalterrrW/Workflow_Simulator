import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class AddTask implements State{

	TaskPool taskPool;

	public AddTask(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("AddTask call()");

			while(true){
				Task task = taskPool.getFromWaitingAddedTasksQueue();
				if(task != null){
					action(task);
					taskPool.addToWaitingTodosQueue(task);
				} else{
					Thread.sleep(1000);
					System.out.println("AddTask break");
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

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("AddTask Action running...");
		return true;
	}
}
