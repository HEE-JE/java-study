package prob02;

import java.util.Scanner;


public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS] ;
		System.out.println("입력하세요");
		// 상품 입력
		for(int i = 0; i < goods.length; i++) {
			goods[i] = new Goods(scanner.next(), scanner.nextInt(), scanner.nextInt());
		}
		
		// 상품 출력
		for(int i = 0; i < goods.length; i++) {
			goods[i].print();
		}
		
		// 자원정리
		scanner.close();
	}
}
