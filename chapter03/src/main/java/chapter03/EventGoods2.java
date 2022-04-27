package chapter03;

import mypackage.Goods2;

public class EventGoods2 extends Goods2 {
	private float discountRate = 0.5f;

	public int getDiscountPrice() {
		// protected는 자식에서 접근이 가능하다.(Goods2 부모 클래스의 protected int price 접근 가능)
		int discountPrice = (int) (discountRate * price); // 명시적 캐스팅(값이 바뀔 위험이 있을때 반드시 해야된다)
		int i = 1000;
		float f = i; // 암시적 캐스팅(값이 바뀔 위험이 없으므로 하지 않아도 된다)
		return discountPrice;
	}
}