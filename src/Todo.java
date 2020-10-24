
public class Todo implements State{

	Manager executorManager;

	public Todo(Manager manager) {
		this.executorManager = manager;
	}

	@Override
	synchronized public String call() {		
		try {
            Thread.sleep(1000);
            System.out.println("Hello from Todo");
        } catch(InterruptedException e) {
            System.out.println("Error");
		// TODO Auto-generated method stub
		return null;
	}
		return null;
	}

}
