package arithmetic;

import java.util.Arrays;
import java.util.Random;

public class SortCompare {
	public static double time(String alg, Comparable[] a) {
		Stopwatch s = new Stopwatch();
		if (alg.equals("Insertion"))
			Insertion.sort(a);
		if (alg.equals("Selection"))
			Selection.sort(a);
		if (alg.equals("Arrays"))
			Arrays.sort(a);
		if (alg.equals("Shell"))
			Shell.sort(a);
		return s.elpasedTime();
	}
	public static void main(String[] args) {
//		Random r = new Random();
		Integer[] d = {4,5,321,321,32,12,32};
//		for (int i = 0; i < 50000; i++) {
//			 d[i] = (Double) r.nextDouble();
//		}
		Shell.sort(d);
		for (Integer integer : d) {
			System.out.println(integer);
		}
	}
}
