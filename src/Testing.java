
public class Testing implements State{
	
	Manager executorManager;

	public Testing(Manager manager) {
		this.executorManager = manager;
	}

	@Override
	synchronized public String call() {
			try {
            Thread.sleep(1000);
            System.out.println("Hallo from Testing");
        } catch(InterruptedException e) {
            System.out.println("Error");
		// TODO Auto-generated method stub
		return null;
	}
		return null;
	}
}
