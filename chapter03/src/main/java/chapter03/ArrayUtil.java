package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}
		return result;
	}

	public static int[] doubleToInt(double[] a) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = (int) a[i];
		}
		return result;
	}

	public static int[] concat(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			result[a.length + i] = b[i];
		}
		return result;
	}
}