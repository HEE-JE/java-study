package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	/* 코드 작성 */
	public Money add(Money money) {
		int result = this.amount + money.getAmount();
		Money addMoney = new Money(result);
		return addMoney;
	}

	public Money minus(Money money) {
		int result = this.amount - money.getAmount();
		Money minusMoney = new Money(result);
		return minusMoney;
	}

	public Money multiply(Money money) {
		int result = this.amount * money.getAmount();
		Money multiplyMoney = new Money(result);
		return multiplyMoney;
	}

	public Money devide(Money money) {
		int result = this.amount / money.getAmount();
		Money devideMoney = new Money(result);
		return devideMoney;
	}

	public boolean equals(Money money) {
		if (money instanceof Money && this.amount == money.amount) {
			return true;
		} else {
			return false;
		}
	}
}
