import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Todo implements State {
    TaskPool taskPool;
    State development;
    State feedback;
    private ExecutorService execute;

    public Todo(TaskPool taskPool) {
        this.taskPool = taskPool;
        this.development = new Development(this.taskPool);
        this.feedback = new Feedback(this.taskPool);
    }

    @Override
    synchronized public String call() {
        try {
            this.execute = Executors.newFixedThreadPool(2);
            System.out.println("Todo call()");
//
//            this.execute.submit(this.development);
//            this.execute.submit(this.feedback);

            this.development.call();
            this.feedback.call();
            Thread.sleep(1000);
            this.taskPool.toDoVar = 1;
            while (true) {
                Task task = taskPool.getFromWaitingTodosQueue();
                if (task != null) {

                    action(task);
                    taskPool.addToWaitingDevelopmentQueue(task);
                    taskPool.addToWaitingFeedbackQueue(task);
                } else {
                    Thread.sleep(1000);
                    if (!taskPool.finishJob) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
            // TODO Auto-generated method stub
            return null;
        }
        return null;
    }

    public boolean action(Task task) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Todo Action running..." + '\n');
        return true;
    }

}
