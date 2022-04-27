package chapter03;

public class StaticMethod {
	int n;
	static int m;

	void f1() {
		// instance 메소드에서는 instance 변수에 접근 가능
		System.out.println(n);
	}

	void f2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름이 생략이 가능하다.
		System.out.println(m);
	}

	void f3() {
		f2();
	}

	void f4() {
		s1();
		// 같은 클래스에서는 클래스(static) 메소드 접근에서는 클래스 이름이 생략이 가능하다.
	}

	static void s1() {
		// System.out.println(n);
		// 오류: statice method에서는 인스턴스 변수에 접근 할 수 없다.
	}

	static void s2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스에서는 클래스(static) 변수 접근에서는 클래스 이름이 생략이 가능하다.
		System.out.println(m);
	}

	static void s3() {
		// f1();
		// 오류: static method에서는 인스턴스 메소드에 접근 할 수 없다.
	}

	static void s4() {
		StaticMethod.s1();
		// 같은 클래스에서는 클래스(static) 메소드 접근에서는 클래스 이름이 생략이 가능하다.
		s1();
	}
}