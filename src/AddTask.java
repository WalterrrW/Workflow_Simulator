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
//			System.out.println("nextState:" + nextState.getClass().getSimpleName());
//			System.out.println("prevState: " + prevState);
//			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingAddedTasksQueue();
				if(task != null){
					action(task);
					taskPool.addToWaitingTodosQueue(task);
				} else{
					Thread.sleep(3000);
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
		System.out.println("AddTask Action running..." + task.getTaskId() + '\n');
		return true;
	}
}
