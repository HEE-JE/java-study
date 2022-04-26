package prob02;

public class Goods {
	private String name;
	private int price, count;
	
	public Goods(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public void print() {
		System.out.println(this.name + "(가격:" + this.price + "원)이 " + this.count + "개 입고 되었습니다");
	}
}