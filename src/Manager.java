import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Manager {
    public HashMap<State, Integer> taskStates;

    public Manager(HashMap<State, Integer> newTask) {
        this.taskStates = newTask;
    }

    // TODO maybe sort by state ID
    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> todoTask;
        ArrayList<State> states = new ArrayList<State>(this.taskStates.keySet());
        int nextState = 0;
        while (true) {
            if (taskStates.get(states.get(nextState)) == 0) {
                todoTask = executorService.submit(states.get(nextState));
                taskStates.put(states.get(nextState), 1);
                nextState+=1;
            }
            
            break;
        }
    }

}
