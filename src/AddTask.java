

public class AddTask implements State{

	Manager executorManager;

	public AddTask(Manager manager) {
		this.executorManager = manager;
	}

	@Override
	synchronized public String call() {		
		try {
            Thread.sleep(1000);
         
            System.out.println("Greetings from AddTask");
        } catch(InterruptedException e) {
            System.out.println("Error");
		// TODO Auto-generated method stub
		return null;
	}
		return null;
	}
}
