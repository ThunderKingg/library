package arithmetic;

/**
 * 选择排序
 * 定义：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
 * 再次，在剩下的元素中找到最小的元素，将它与数组中的第二个元素交换位置。
 * 如此往复，直到将整个数组排序。这种方法叫做选择排序，因为它在不断地选择剩余元素中最小者。
 * 
 * 创建自己的数据类型时，需要实现Comparable接口实现compareTo()
 * 
 * 对于v<w、v=w和v>w三种情况
 * 习惯v.compareTo(w)被调用时返回一个负整数、零和一个正整数
 * v<w 返回-1
 * v=w 返回0
 * v>w 返回1
 * 此外,compareTo()必须实现一个完整的比较序列，即：
 * 自反性：对于所有的v，v=v;
 * 反对称性：对于所有的v<w都有w>v,且v=w时，w=v
 * 传递性，对于v,w和x,如果v<=w且w<=x,则v<=w;
 * @author Administrator
 *
 */
public class Selection {
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
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
		Integer[] a = {5,2,1,4,54,23};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
