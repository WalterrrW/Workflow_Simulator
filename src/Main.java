import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 0 - state not started
        // 1 - state started
        // 2 - state finished
        // 3 - state rejected
        Todo todo = new Todo();
        AddTask addTask = new AddTask();
        Development development = new Development();
        Feedback feedback = new Feedback();
        Testing testing = new Testing();

        HashMap<State, Integer> currentStatesForTask = new HashMap<State, Integer>();

        currentStatesForTask.put(todo, 0);
        currentStatesForTask.put(addTask, 0);
        currentStatesForTask.put(development, 0);
        currentStatesForTask.put(feedback, 0);
        currentStatesForTask.put(testing, 0);

        Manager orchestrator = new Manager(currentStatesForTask);
        orchestrator.execute();
    }

}
