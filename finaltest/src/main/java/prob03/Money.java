package prob03;

public class Money {
	private int amount;

	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}

	public Money add(Money money) {
		this.amount += money.amount;
		Money addMoney = new Money(this.amount);
		return addMoney;
	}

	public Money minus(Money money) {
		this.amount -= money.amount;
		Money minusMoney = new Money(this.amount);
		return minusMoney;
	}

	public Money multiply(Money money) {
		this.amount *= money.amount;
		Money multiplyMoney = new Money(this.amount);
		return multiplyMoney;
	}

	public Money devide(Money money) {
		this.amount /= money.amount;
		Money devideMoney = new Money(this.amount);
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
