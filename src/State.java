import java.util.concurrent.Callable;

public interface State extends Callable<String>{
	
	public String call();
	
}
