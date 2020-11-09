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

                Task task = taskPool.getFromWaitingTodosQueue();
                this.execute = Executors.newFixedThreadPool(2);
                Future<Integer> returnFeedbackValue = this.execute.submit(this.feedback);
                 this.execute.submit(this.development);

                System.out.println("Todo set toDoVar to 1");
                this.taskPool.setToDoVar(1);
                Runtime.getRuntime().exec("cmd /c setx varManagerTodo 1");

                if (task != null) {
                    action(task);
                    taskPool.addToWaitingDevelopmentQueue(task);
                    taskPool.addToWaitingFeedbackQueue(task);
                } else {
                    System.out.println("Todo break");
                }

                while(true){
                    if(returnFeedbackValue.get() == 1){
                        execute.shutdownNow();
                        System.out.println("Feedback fisrt kill Dev");
                        break;
                    } else if(returnFeedbackValue.get() == 0){
                        System.out.println("feedback comes after dev, expected behaviour");
                        break;
                    }
                }

        } catch (Exception e) {
            System.out.println("Error from Todo");
            // TODO Auto-generated method stub
            return 1;
        }
        return 0;
    }

    public boolean action(Task task)  {
        System.out.println("Todo Action running on task " + task.getTaskId());
        return true;
    }

}
