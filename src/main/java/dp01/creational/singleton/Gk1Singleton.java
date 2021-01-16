package dp01.creational.singleton;

public class Gk1Singleton {

	public static void main(String[] args) {
		
		/************************************
		 Thumb Rule to Create a Singleton Class
		 ************************************
		
		 1. It should be a final class
		 2. It should have a private Constructor
		 3. Should have private instance variable of the the same class type. 
		 4. Instance variable should be static
		 5. Static factory method to get the object.
		************************************/
		
		BasicSingletonTest object1 = BasicSingletonTest.getSingletonObject();
		System.out.println(object1);
		
		BasicSingletonTest object2 = BasicSingletonTest.getSingletonObject();
		System.out.println(object2);
		
		BasicSingletonTest object3 = BasicSingletonTest.getSingletonObject();
		System.out.println(object3);
		
		BasicSingletonTest object4 = BasicSingletonTest.getSingletonObject();
		System.out.println(object4);
	}
}


// Final Class
final class BasicSingletonTest {
	
	// Private static instance member
	private static BasicSingletonTest basicSingletonObj;
	
	// Private Constructor
	private BasicSingletonTest() {
		// Private Constructor
	}
	
	
	// Static Factory Method to get the singleton Object
	// To make Thread Safe, we can make the static method as synchronized
	public static /*synchronized*/ BasicSingletonTest getSingletonObject() {
		
		if(basicSingletonObj == null) {
			basicSingletonObj = new BasicSingletonTest();
		}
		return basicSingletonObj;
	}
}



