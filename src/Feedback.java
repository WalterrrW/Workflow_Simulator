import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Feedback implements State{

	State nextState;
	State prevState;
	TaskPool taskPool;
	//	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	public Feedback(TaskPool taskPool){
		this.taskPool = taskPool;
	}

	@Override
	synchronized public String call() {
		try {
			System.out.println("Feedback call()");
			nextState = taskPool.getNextStateForFeedback();
			prevState = taskPool.getPrevStateForFeedback();
//			System.out.println("nextState: " + nextState.getClass().getSimpleName());
//			System.out.println("prevState: " + prevState.getClass().getSimpleName());
//			System.out.println();
			
			while(true){
				Task task = taskPool.getFromWaitingFeedbackQueue();
				if(task != null){
					if(action(task)){
						taskPool.addToWaitingTestingQueue(task);
					} else {
						taskPool.addToWaitingDevelopmentQueue(task);
					}
				} else{
					Thread.sleep(3000);
					if(!taskPool.finishJob){
						break;
					}
				}
			}
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Error");
			// TODO Auto-generated method stub
			return null;
		}
		return null;
	}

	public boolean action(Task task) throws InterruptedException {
		Thread.sleep(2000);
		if(rd.nextBoolean()){
			System.out.println("Feedback Action completed..." + task.getTaskId() + '\n');
			return true;
		}
		System.out.println("Feedback Action failed..." + task.getTaskId() + '\n');
		return false;
	}

	// to make it quicker uncomment method below  and comment the method above
//	public boolean action(Task task) throws InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("AddTask Action running..." + task.getTaskId() + '\n');
//		return true;
//	}





	// the solution where you type your response is not good because
	// the console and printing won't have an order

//	public boolean action(Task task) throws InterruptedException {
//		Thread.sleep(2000);
//		System.out.println("Have Task number " + task.getTaskId() + " passed your feedback?");
//		System.out.println("Your answer (yes/no) :  ");
//		String response = sc.nextLine();
//		if(response.equals("yes")){
//			return true;
//		} else if(response.equals("no")){
//			return false;
//		} else {
//			System.out.println("Bad input");
//			return action(task);
//		}
//	}
}
