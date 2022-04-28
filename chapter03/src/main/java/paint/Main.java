package paint;

public class Main {

	public static void main(String[] args) {
		// Point point1 = new Point();
		// point1.setX(20);
		// point1.setY(10);
		// point1.show();
		Point point1 = new Point(20, 10);
		drawPoint(point1);

		Point point2 = new Point(50, 100);
		drawPoint(point2);
		point2.show(false);

		Point point3 = new ColorPoint(40, 50, "red");
		drawPoint(point3);
		// point3.show(true);

		Triangle triangle = new Triangle();
		drawTriangle(triangle);

		Rectangle rectangle = new Rectangle();
		drawRectangle(rectangle);
	}

	public static void drawPoint(Point point) {
		point.show();
	}

//	public static void drawPoint(ColorPoint point) {
//		point.show();
//	}

	public static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}

	public static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	}
}