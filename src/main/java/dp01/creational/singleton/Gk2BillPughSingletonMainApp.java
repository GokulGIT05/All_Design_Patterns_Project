package dp01.creational.singleton;

public class Gk2BillPughSingletonMainApp {

	public static void main(String[] args) {
		
		BillPughSingleton Object1 = BillPughSingleton.getInstance();
		System.out.println(Object1);
		
		BillPughSingleton Object2 = BillPughSingleton.getInstance();
		System.out.println(Object2);
		
		BillPughSingleton Object3 = BillPughSingleton.getInstance();
		System.out.println(Object3);
		
		BillPughSingleton Object4 = BillPughSingleton.getInstance();
		System.out.println(Object4);
		
		/* Why ?
		 * 
		 * Inner static class mare by default thread-safe
		 * Only when the factory method called, instance of that object will be created
		 * 
		 */
	}

}

// final class
final class BillPughSingleton {
	
	// Private Constructor
	private BillPughSingleton() {
		
	}
	
	// Inner static private class
	private static class BillPushSingletonHelper{
		
		// Creating the static variable
		private static BillPughSingleton SINGLETON_INSTANCE = new BillPughSingleton();
	}
	
	// Static factory method to get the instance.
	public static BillPughSingleton getInstance() {
		return BillPushSingletonHelper.SINGLETON_INSTANCE;
	}
}
