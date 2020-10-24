import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Manager {
	
	public boolean addTaskVar;
	public boolean todoVar;
	public boolean developmentVar;
	public boolean feedbackVar;
	public boolean testingVar;
	
	public void execute() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		Todo todo = new Todo(this);
		AddTask addTask = new AddTask(this);
		Development development = new Development(this);
		Feedback feedback = new Feedback(this);
		Testing testing = new Testing(this);
		
		while (true) {
			Future<String> thread = executorService.submit(addTask);
			
		}
		
		
		executorService.submit(addTask);
		executorService.submit(todo);
		executorService.submit(development);
		executorService.submit(feedback);
		executorService.submit(testing);
		
	}
	
}
