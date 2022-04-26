package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			String str = String.valueOf(i); // valueOf() => 숫자를 문자열로 변경
			int clap = 0;

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j); // charAt() => 문자열을 char배열로 변경
				if (c == '3' || c == '6' || c == '9') {
					clap++;
				}
			}

			if (clap == 0) {
				continue;
			}

			System.out.print(str + " ");
			for (int j = 0; j < clap; j++) {
				System.out.print("짝");
			}
			System.out.println();
		}
	}
}