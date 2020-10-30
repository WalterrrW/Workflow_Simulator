
public class Feedback implements State{


	@Override
synchronized public String call() {
		try {
            Thread.sleep(1000);
            System.out.println("Hey from Feedback");
        } catch(InterruptedException e) {
            System.out.println("Error");
		// TODO Auto-generated method stub
		return null;
	}
		return null;
	}
}
