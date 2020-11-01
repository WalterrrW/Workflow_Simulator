import java.util.concurrent.Callable;

public interface State extends Callable<String>{
	
	public String call();
//	public void addTask(Task task);
//	public void addNextState(State nextState);
	
}
