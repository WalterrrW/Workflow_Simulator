import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Manager {

    public static void run(){

        TaskPool taskPool = new TaskPool();

        State addTask = new AddTask(taskPool);
        State todo = new Todo(taskPool);
        State development = new Development(taskPool);
        State feedback = new Feedback(taskPool);
        State testing = new Testing(taskPool);

        taskPool.setNextStateForAddTask(todo);
        taskPool.setNextStateForTodo(development);
        taskPool.setNextStateForDevelopment(feedback);
        taskPool.setNextStateForFeedback(testing);
//        taskPool.setNextStateForTesting();

//        taskPool.setPrevStateForAddTask();
//        taskPool.setPrevStateForTodo();
//        taskPool.setPrevStateForDevelopment();
        taskPool.setPrevStateForFeedback(development);
        taskPool.setPrevStateForTesting(development);

        taskPool.addToWaitingAddedTasksQueue(new Task(7));

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        try {
            executorService.submit(addTask);
            TimeUnit.SECONDS.sleep(3);
            executorService.submit(todo);
            TimeUnit.SECONDS.sleep(3);
            executorService.submit(development);
            TimeUnit.SECONDS.sleep(3);
            executorService.submit(feedback);
            TimeUnit.SECONDS.sleep(3);
            executorService.submit(testing);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }











//    public HashMap<State, Integer> taskStates;
//
//    public Manager(HashMap<State, Integer> newTask) {
//        this.taskStates = newTask;
//    }
//
//    // TODO maybe sort by state ID
//    public void execute() {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Future<String> todoTask;
//        ArrayList<State> states = new ArrayList<State>(this.taskStates.keySet());
//        int nextState = 0;
//        while (true) {
//            if (taskStates.get(states.get(nextState)) == 0) {
//                todoTask = executorService.submit(states.get(nextState));
//                taskStates.put(states.get(nextState), 1);
//                nextState+=1;
//            }
//
//            break;
//        }
//    }

}
