import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Todo implements State {
    TaskPool taskPool;
    State development;
    State feedback;
    private ExecutorService execute;
    Random rd = new Random();

    public Todo(TaskPool taskPool) {
        this.taskPool = taskPool;
        this.development = new Development(taskPool);
        this.feedback = new Feedback(taskPool);
    }

    @Override
    synchronized public String call() {
        try {
            System.out.println("Todo Call()");

            Thread.sleep(3000);

            while (true) {
                Task task = taskPool.getFromWaitingTodosQueue();
                if (task != null) {
                    action(task);

                    this.execute = Executors.newFixedThreadPool(2);

                    int randomTime =  rd.nextInt(2000);
                    System.out.println("Todo will sleep " + randomTime + "ms before setting todoVar");
                    Thread.sleep(randomTime);
                    this.taskPool.setToDoVar(1);

                    this.execute.submit(this.development);
                    this.execute.submit(this.feedback);

                    taskPool.addToWaitingDevelopmentQueue(task);
                    taskPool.addToWaitingFeedbackQueue(task);
                } else {
                    Thread.sleep(1000);
                    System.out.println("Todo break");
                    break;
//                    if (!taskPool.finishJob) {
////                        break;
//                    }
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
