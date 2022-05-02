package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest02 {

	public static void main(String[] args) {
		Set<Gugudan> s = new HashSet<>();

		s.add(new Gugudan(2, 3));
		s.add(new Gugudan(9, 9));
		// 같은 것이 들어간다, Gugudan클래스에서 hashCode와 equals를 오버라이딩하면 안들어간다.
		s.add(new Gugudan(2, 3));

		for (Gugudan g : s) {
			System.out.println(g); // 순서 없이 순회
		}
	}
}