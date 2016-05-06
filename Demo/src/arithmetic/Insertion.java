package arithmetic;

public class Insertion {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
