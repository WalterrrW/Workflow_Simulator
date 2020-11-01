import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class AddTask implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;

	public AddTask(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("AddTask call()");
			nextState = taskPool.getNextStateForAddTask();
			prevState = taskPool.getPrevStateForAddTask();
			System.out.println(nextState.getClass().getSimpleName());
			System.out.println(prevState);
			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingAddedTasksQueue();
				if(task != null){
					action();
					taskPool.addToWaitingTodosQueue(task);
//					continue;
				} else{
					Thread.sleep(15000);
					System.out.println("No task to be added!");
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
		System.out.println("AddTask Action running...\n");
		return true;
	}
}
