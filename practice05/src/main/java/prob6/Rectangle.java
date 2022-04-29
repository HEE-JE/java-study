package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;

	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}

	@Override
	public void resize(double s) {
		this.width *= s;
		this.height *= s;
	}
}