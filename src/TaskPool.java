import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskPool {
    private Queue<Task> waitingAddedTasksQueue = new PriorityBlockingQueue<>();
    private Queue<Task> waitingTodosQueue = new PriorityBlockingQueue<>();
    private Queue<Task> waitingDevelopmentQueue = new PriorityBlockingQueue<>();
    private Queue<Task> waitingFeedbackQueue = new PriorityBlockingQueue<>();
    private Queue<Task> waitingTestingQueue = new PriorityBlockingQueue<>();

    private State nextStateForAddTask;
    private State nextStateForTodo;
    private State nextStateForDevelopment;
    private State nextStateForFeedback;
    private State nextStateForTesting;

    private State prevStateForAddTask;
    private State prevStateForTodo;
    private State prevStateForDevelopment;
    private State prevStateForFeedback;
    private State prevStateForTesting;

    /*
     * Below you can see
     * getters and setters
     * to the above variables
     * and also some methods for
     * adding an removing from the Queues
     * */

    public State getNextStateForAddTask() {
        return nextStateForAddTask;
    }

    public void setNextStateForAddTask(State nextStateForAddTask) {
        this.nextStateForAddTask = nextStateForAddTask;
    }

    public State getNextStateForTodo() {
        return nextStateForTodo;
    }

    public void setNextStateForTodo(State nextStateForTodo) {
        this.nextStateForTodo = nextStateForTodo;
    }

    public State getNextStateForDevelopment() {
        return nextStateForDevelopment;
    }

    public void setNextStateForDevelopment(State nextStateForDevelopment) {
        this.nextStateForDevelopment = nextStateForDevelopment;
    }

    public State getNextStateForFeedback() {
        return nextStateForFeedback;
    }

    public void setNextStateForFeedback(State nextStateForFeedback) {
        this.nextStateForFeedback = nextStateForFeedback;
    }

    public State getNextStateForTesting() {
        return nextStateForTesting;
    }

    public void setNextStateForTesting(State nextStateForTesting) {
        this.nextStateForTesting = nextStateForTesting;
    }

    public State getPrevStateForAddTask() {
        return prevStateForAddTask;
    }

    public void setPrevStateForAddTask(State prevStateForAddTask) {
        this.prevStateForAddTask = prevStateForAddTask;
    }

    public State getPrevStateForTodo() {
        return prevStateForTodo;
    }

    public void setPrevStateForTodo(State prevStateForTodo) {
        this.prevStateForTodo = prevStateForTodo;
    }

    public State getPrevStateForDevelopment() {
        return prevStateForDevelopment;
    }

    public void setPrevStateForDevelopment(State prevStateForDevelopment) {
        this.prevStateForDevelopment = prevStateForDevelopment;
    }

    public State getPrevStateForFeedback() {
        return prevStateForFeedback;
    }

    public void setPrevStateForFeedback(State prevStateForFeedback) {
        this.prevStateForFeedback = prevStateForFeedback;
    }

    public State getPrevStateForTesting() {
        return prevStateForTesting;
    }

    public void setPrevStateForTesting(State prevStateForTesting) {
        this.prevStateForTesting = prevStateForTesting;
    }

    public void addToWaitingAddedTasksQueue(Task addTask){
        waitingAddedTasksQueue.add(addTask);
    }

    public Task getFromWaitingAddedTasksQueue(){
        if(waitingAddedTasksQueue.size() != 0) {
            return waitingAddedTasksQueue.remove();
        } else {
            return null;
        }
    }

    public void addToWaitingTodosQueue(Task todo){
        waitingTodosQueue.add(todo);
    }

    public Task getFromWaitingTodosQueue(){
        if(waitingTodosQueue.size() != 0) {
            return waitingTodosQueue.remove();
        } else {
            return null;
        }
    }

    public void addToWaitingDevelopmentQueue(Task development){
        waitingDevelopmentQueue.add(development);
    }

    public Task getFromWaitingDevelopmentQueue(){
        if(waitingDevelopmentQueue.size() != 0) {
            return waitingDevelopmentQueue.remove();
        } else {
            return null;
        }
    }

    public void addToWaitingFeedbackQueue(Task feedback){
        waitingFeedbackQueue.add(feedback);
    }

    public Task getFromWaitingFeedbackQueue(){
        if(waitingFeedbackQueue.size() != 0) {
            return waitingFeedbackQueue.remove();
        } else {
            return null;
        }
    }

    public void addToWaitingTestingQueue(Task testing){
        waitingTestingQueue.add(testing);
    }

    public Task getFromWaitingTestingQueue(){
        if(waitingTestingQueue.size() != 0) {
            return waitingTestingQueue.remove();
        } else {
            return null;
        }
    }
}
