package arithmetic;

import java.util.Arrays;

/**
 * 排序模板
 * sort()具体排序算法
 * less()对元素进行比较
 * exch()对元素进行交换位置
 * @author Administrator
 *
 */
public class Example {
	public static void sort(Comparable[] a) {
		
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] a = {"5","2","3","4"};
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
