package chapter03;

public class Goods {
	public static int countOfGoods; // 클래스 변수, 공유 변수
	// 인스턴스 변수는 보통 private선언해서 캡슐화(정보은닉)
	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods() { // 기본생성자, 없으면 컴파일러가 자동으로 생성
		Goods.countOfGoods = Goods.countOfGoods + 1;
	}

	// 인스턴스 변수에 접근할때 getter/setter사용
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		// 값 보호
		if (price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println(
				"name: " + name + ", price: " + price + ", countStock: " + countStock + ", countSold: " + countSold);
	}

	public int calcDiscountPrice(double discountRate) {
		return (int) (discountRate * price);
	}
}