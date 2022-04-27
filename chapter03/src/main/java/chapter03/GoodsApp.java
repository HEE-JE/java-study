package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods(); // 레퍼런스 변수 camera에 Goods객체 생성

		camera.setName("nikon");
		camera.setPrice(-1);
		camera.setCountSold(50); // 팔린개수
		camera.setCountStock(30); // 재고개수

		camera.showInfo();

		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		System.out.println("Goods Count : " + Goods.countOfGoods);

		// discount price 구하기 
		camera.setPrice(2000);
		int discountPrice = camera.calcDiscountPrice(0.5);
		System.out.println("Goods Discount Price: " + discountPrice);
	}
}