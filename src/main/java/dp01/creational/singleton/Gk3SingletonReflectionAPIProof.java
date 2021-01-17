package dp01.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Gk3SingletonReflectionAPIProof {


	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		BasicSingletonTest singletonObject01 = BasicSingletonTest.getSingletonObject();
		System.out.println(singletonObject01);
		
		BasicSingletonTest singletonObject02 = BasicSingletonTest.getSingletonObject();
		System.out.println(singletonObject02);
		
		System.out.println("***************************");
		// Above Singleton Class is breakable via Reflection API
		
		BasicSingletonTest singletonObject03 = null;

		Constructor[] allConstructors =  BasicSingletonTest.class.getDeclaredConstructors();
		
		for(Constructor eachConstructor : allConstructors) {
			System.out.println(eachConstructor);
			
			eachConstructor.setAccessible(true); // if its not set to true, then we will get IllegalAccessException.
			
			try {
				singletonObject03 = (BasicSingletonTest) eachConstructor.newInstance(); // New instance is created
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(singletonObject01);
		System.out.println(singletonObject02);
		System.out.println(singletonObject03); // Hash code will be different than above two objects
		
		// So if we create a singleton class its very much breakable using reflection Concepts
		
		// To overcome reflection problem, we have to use enum.
		
		SingletonReflectionProof obj1 = SingletonReflectionProof.INSTANCE;
		System.out.println(obj1.hashCode());
		
		SingletonReflectionProof obj2 = SingletonReflectionProof.INSTANCE;
		System.out.println(obj2.hashCode());
	}
}

// JVM handles the creation and invocation of enum constructors internally
 enum SingletonReflectionProof{
	 
	 INSTANCE;
	
}