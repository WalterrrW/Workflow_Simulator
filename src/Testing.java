import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Testing implements State{

	TaskPool taskPool;
	Random rd = new Random();

	public Testing(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public Integer call() {
		try {
			Task task = taskPool.getFromWaitingTestingQueue();
			System.out.println("Testing call()");
			if(taskPool.getToDoVar() == 3){
				if(task!=null){
					action(task);
				}
				System.out.println("Task finished from Testing");
			} else {
				System.out.println("test failed");
			}
		} catch(Exception e) {
			System.out.println("Error from Testing");
			// TODO Auto-generated method stub
			return 1;
		}
		return 0;
	}

	public boolean action(Task task) throws InterruptedException {
			System.out.println("Testing Action running on task " + task.getTaskId());
			return true;
		}

}
