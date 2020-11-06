import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TaskPool {

    public boolean finishJob = true;
    public int toDoVar = 0;
    public int devVar = 0;

    private Queue<Task> waitingAddedTasksQueue = new LinkedList<>();
    private Queue<Task> waitingTodosQueue = new LinkedList<>();
    private Queue<Task> waitingDevelopmentQueue = new LinkedList<>();
    private Queue<Task> waitingFeedbackQueue = new LinkedList<>();
    private Queue<Task> waitingTestingQueue = new LinkedList<>();

    /*
     * Below you can see
     * getters and setters
     * to the above variables
     * and also some methods for
     * adding an removing from the Queues
     * */
    public void addToWaitingAddedTasksQueue(Task addTask){
        waitingAddedTasksQueue.add(addTask);
    }

    public Task getFromWaitingAddedTasksQueue(){
        if(waitingAddedTasksQueue.size() != 0) {
            return waitingAddedTasksQueue.poll();
        } else {
            return null;
        }
    }

    public void addToWaitingTodosQueue(Task todo){
        waitingTodosQueue.add(todo);
    }

    public Task getFromWaitingTodosQueue(){
        if(waitingTodosQueue.size() != 0) {
            return waitingTodosQueue.poll();
        } else {
            return null;
        }
    }

    public void addToWaitingDevelopmentQueue(Task development){
        waitingDevelopmentQueue.add(development);
    }

    public Task getFromWaitingDevelopmentQueue(){
        if(waitingDevelopmentQueue.size() != 0) {
            return waitingDevelopmentQueue.poll();
        } else {
            return null;
        }
    }

    public void addToWaitingFeedbackQueue(Task feedback){
        waitingFeedbackQueue.add(feedback);
    }

    public Task getFromWaitingFeedbackQueue(){
        if(waitingFeedbackQueue.size() != 0) {
            return waitingFeedbackQueue.poll();
        } else {
            return null;
        }
    }

    public void addToWaitingTestingQueue(Task testing){
        waitingTestingQueue.add(testing);
    }

    public Task getFromWaitingTestingQueue(){
        if(waitingTestingQueue.size() != 0) {
            return waitingTestingQueue.poll();
        } else {
            return null;
        }
    }
}
