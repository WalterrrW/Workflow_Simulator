public class Task implements Comparable{

//public class Task{
    private int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    public int getTaskId(){
        return taskId;
    }

    public void setTaskId(int newTaskId){
        taskId = newTaskId;
    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo((Task) o);
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}
