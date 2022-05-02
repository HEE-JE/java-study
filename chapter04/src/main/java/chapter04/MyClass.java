package chapter04;

public class MyClass {
	// Singleton = 객체를 1개로 유지
	private static MyClass instance = null;

	private MyClass() {

	}

	public static MyClass getInstance() {
		if (instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}