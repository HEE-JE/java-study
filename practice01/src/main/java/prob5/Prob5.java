package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			int ten_num = i / 10;
			int num = i % 10;

			if (num % 3 == 0 && num != 0) {
				System.out.print(i + " 짝");
				if (ten_num % 3 == 0 && ten_num != 0) {
					System.out.println("짝");
				} else {
					System.out.println();
				}
			} else {
				if (ten_num % 3 == 0 && ten_num != 0) {
					System.out.println(i + " 짝");
				}
			}
		}
	}
}