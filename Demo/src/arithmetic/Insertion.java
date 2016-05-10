package arithmetic;

public class Insertion extends Example {
	
	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
}
