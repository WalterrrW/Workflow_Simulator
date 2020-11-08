import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
        Random rd = new Random();
    }

    @Override
    synchronized public Integer call() {
        try {
            System.out.println("Todo Call()");

            while (true) {
                Task task = taskPool.getFromWaitingTodosQueue();
                this.execute = Executors.newFixedThreadPool(2);
                Future<Integer> returnFeedbackValue = this.execute.submit(this.feedback);
                Future<Integer> returnDevValue = this.execute.submit(this.development);

                int randomTime =  rd.nextInt(1000);
                System.out.println("Todo will sleep " + randomTime + "ms before setting todoVar");
                Thread.sleep(randomTime);
                System.out.println("Todo set toDoVar to 1");
                this.taskPool.setToDoVar(1);


                if (task != null) {
                action(task);
                    taskPool.addToWaitingDevelopmentQueue(task);
                    taskPool.addToWaitingFeedbackQueue(task);
                } else {
                    Thread.sleep(1000);
                    System.out.println("Todo break");
                    break;
                }

//                if(!returnDevValue.isDone()) {
//                   if( returnDevValue.get();
//                }
            }


        } catch (Exception e) {
            System.out.println("Error");
            // TODO Auto-generated method stub
            return 1;
        }
        return 0;
    }

    public boolean action(Task task) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Todo Action running...");
        return true;
    }

}
