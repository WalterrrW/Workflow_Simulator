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
        State testing = new Testing(taskPool);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            taskPool.addToWaitingAddedTasksQueue(new Task(7));
            executorService.submit(addTask);
            TimeUnit.SECONDS.sleep(10000);
//            executorService.submit(testing);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
