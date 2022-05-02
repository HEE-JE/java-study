package prob04;

public class Depart extends Employee {
	private String department;

	public Depart(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}

	public void setDepart(String department) {
		this.department = department;
	}

	public String getDepart() {
		return department;
	}
	
	@Override
	public void getInformation() {
//		super.getInformation();
//		System.out.println(" 부서: " + department);
		System.out.println("이름:" + getName() + " 연봉:" + getSalary() + " 부서:" + department);
	}
}