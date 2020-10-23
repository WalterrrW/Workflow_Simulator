import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Manager {

	public static void execute() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Todo todo = new Todo();
		AddTask addTask = new AddTask();
		Development development = new Development();
		Feedback feedback = new Feedback();
		Testing testing = new Testing();
		
		executorService.submit(todo);
		executorService.submit(addTask);
		executorService.submit(development);
		executorService.submit(feedback);
		executorService.submit(testing);
		
	}
	
}
