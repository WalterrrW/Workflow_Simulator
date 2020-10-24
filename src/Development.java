
public class Development implements State{

	Manager executorManager;

	public Development(Manager manager) {
		this.executorManager = manager;
	}

	@Override
	synchronized public String call() {		
		try {
            Thread.sleep(1000);
            System.out.println("Salut from Development");
        } catch(InterruptedException e) {
            System.out.println("Error");
		// TODO Auto-generated method stub
		return null;
	}
		return null;
	}
}
