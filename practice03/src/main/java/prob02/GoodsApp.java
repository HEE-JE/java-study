package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		System.out.println("입력하세요");
		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] datas = line.split(" "); // 공백을 기준으로 배열에 저장

			String name = datas[0];
			int price = Integer.parseInt(datas[1]);
			int count = Integer.parseInt(datas[2]);
			
			goods[i] = new Goods(name, price, count);

		}
		// 상품 출력
		for(Goods i : goods) {
			i.print();
		}

		// 자원정리
		scanner.close();
	}
}
