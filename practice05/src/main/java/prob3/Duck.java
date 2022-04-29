package prob3;

public class Duck extends Bird {
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fly() {
		System.out.println("오리(" + getName() + ")는 날지 않습니다.");
	}

	@Override
	public void sing() {
		System.out.println("오리(" + getName() + ")는 소리내어 웁니다.");
	}

	@Override
	public String toString() { // System.out.println(Duck)을 실행하면 메소드 실행
		return "오리의 이름은 " + name + " 입니다.";
	}
}