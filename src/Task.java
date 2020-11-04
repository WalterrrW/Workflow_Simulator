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

    // somehow use this method to compare task just for Queue not to complain
    @Override
    public int compareTo(Object o) {
        return this.compareTo((Task) o);
    }

//    @Override
//    public int compareTo(Object o) {
//        return Task.compare((Task) o, this);
//    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
}
