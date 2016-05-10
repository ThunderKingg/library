package arithmetic;

import java.util.Arrays;
import java.util.Random;

public class SortCompare {
	@SuppressWarnings("rawtypes")
	public static double time(String alg, Comparable[] a) {
		Stopwatch s = new Stopwatch();
		Example e = null;
		if (alg.equals("Insertion"))
			e = new Insertion();
		if (alg.equals("Selection"))
			e = new Selection();
		if (alg.equals("Shell"))
			e = new Shell();
		if (alg.equals("Arrays"))
			Arrays.sort(a);
		else 
			e.sort(a);
		return s.elpasedTime();
	}
	public static void main(String[] args) {
		Random r = new Random();
		Double[] d = new Double[50000];
		for (int i = 0; i < 50000; i++) {
			 d[i] = (Double) r.nextDouble();
		}
		System.out.println(time("Arrays", d));

	}
}
