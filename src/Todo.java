import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Todo implements State {

    State nextState;
    State prevState;
    TaskPool taskPool;

    public Todo(TaskPool taskPool){
        this.taskPool = taskPool;
    }

    @Override
    synchronized public String call() {
        try {
            System.out.println("Todo call()");
            nextState = taskPool.getNextStateForTodo();
            prevState = taskPool.getPrevStateForTodo();
//            System.out.println("nextState: " + nextState.getClass().getSimpleName());
//            System.out.println("prevState: " + prevState);
//            System.out.println();

            while(true){
                Task task = taskPool.getFromWaitingTodosQueue();
                if(task != null){
                    action(task);
                    taskPool.addToWaitingDevelopmentQueue(task);
//					continue;
                } else{
                    Thread.sleep(3000);
                    if(!taskPool.finishJob){
                        break;
                    }
//                    System.out.println("No task to be added to Todo!");
//                    break;
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
        System.out.println("Todo Action running..." + task.getTaskId() + '\n');
        return true;
    }

}
