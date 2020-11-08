import java.util.concurrent.Callable;

public interface State extends Callable<Integer>{
	
	public Integer call();
//	public void addTask(Task task);
//	public void addNextState(State nextState);
	
}
