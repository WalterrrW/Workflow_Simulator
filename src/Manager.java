import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Manager {



    public static void run() {

        TaskPool taskPool = new TaskPool();

        State addTask = new AddTask(taskPool);
        State todo = new Todo(taskPool);
        State testing = new Testing(taskPool);

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        try {
            executorService.submit(addTask);
            executorService.submit(todo);
//            executorService.submit(testing);


            taskPool.addToWaitingAddedTasksQueue(new Task(7));
            TimeUnit.SECONDS.sleep(2);
//            taskPool.addToWaitingAddedTasksQueue(new Task(8));
//            TimeUnit.SECONDS.sleep(2);
//            taskPool.addToWaitingAddedTasksQueue(new Task(9));
//        taskPool.addToWaitingAddedTasksQueue(new Task(8));
//            TimeUnit.SECONDS.sleep(2);
//        taskPool.addToWaitingAddedTasksQueue(new Task(9));
//            TimeUnit.SECONDS.sleep(2);
//        taskPool.addToWaitingAddedTasksQueue(new Task(10));

            TimeUnit.SECONDS.sleep(55);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        taskPool.finishJob = false;

        executorService.shutdown();

    }
}
