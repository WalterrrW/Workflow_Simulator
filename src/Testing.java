import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Testing implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;

	public Testing(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Testing call()");
			nextState = taskPool.getNextStateForTesting();
			prevState = taskPool.getPrevStateForTesting();
			System.out.println(nextState);
			System.out.println(prevState.getClass().getSimpleName());
			System.out.println();

			while(true){
				Task task = taskPool.getFromWaitingTodosQueue();
				if(task != null){
					action();
//					taskPool.addToWaitingDevelopmentQueue(task);
//					continue;
				} else{
					Thread.sleep(10000);
					System.out.println("No task to be added to Testing!");
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
		System.out.println("Testing Action running...\n");
		return true;
	}
}
