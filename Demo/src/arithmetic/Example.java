package arithmetic;

import java.util.Arrays;

/**
 * 排序模板
 * @author Administrator
 *
 */
public class Example {
	/**
	 * 具体的排序算法
	 * @param a 任意实现了Comparable接口的数组
	 */
	public static void sort(Comparable[] a) {
		
	}
	
	/**
	 * 对元素进行比较
	 * @param v 元素v
	 * @param w 元素w
	 * @return v是否小于w的结果，返回boolean类型
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * 对给定数组给定的两个下标交换位置
	 * @param a 给定的数组
	 * @param i 需要交换元素下标
	 * @param j 需要交换元素下标
	 */
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
	/**
	 * 对于给定数组检查是否是有序的排列的(升序)
	 * @param a 给定实现了Comparable接口的数组
	 * @return 如果有序返回true,否则返回false
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	/**
	 * 程序入口
	 * @param args 
	 */
	public static void main(String[] args) {
		Integer[] a = {5,2,1,4,54,23};
		Insertion.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
