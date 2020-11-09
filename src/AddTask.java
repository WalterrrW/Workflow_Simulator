import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class AddTask implements State{

	TaskPool taskPool;
	State todo ;
	ExecutorService executorService;

	public AddTask(TaskPool taskPool){
		this.taskPool = taskPool;
		this.todo = new Todo(taskPool);
		executorService = Executors.newFixedThreadPool(1);
	}

	@Override
	synchronized public Integer call() {
		try {
				System.out.println("AddTask has been called from manager, now running...");

				Task task = taskPool.getFromWaitingAddedTasksQueue();
				if(task != null){
					action(task);
					taskPool.addToWaitingTodosQueue(task);
					executorService.submit(todo);
				} else{
					Thread.sleep(1000);
					System.out.println("AddTask found no task in the input queue");
				}
        } catch(Exception e) {
            System.out.println("Error from AddTask");
		// TODO Auto-generated method stub
		return 1;
	}
		return 0;
	}

	public boolean action(Task task){
		System.out.println("AddTask action running on task " + task.getTaskId());
		System.out.println("-----------------------------------------------------");
		return true;
	}
}
