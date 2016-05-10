package arithmetic;

/**
 * 选择排序
 * 定义：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
 * 再次，在剩下的元素中找到最小的元素，将它与数组中的第二个元素交换位置。
 * 如此往复，直到将整个数组排序。这种方法叫做选择排序，因为它在不断地选择剩余元素中最小者。
 * 
 * 创建自己的数据类型时，需要实现Comparable接口实现compareTo()
 * 
 * 习惯v.compareTo(w)被调用时返回一个负整数、零和一个正整数
 * @author 王雷
 *
 */
public class Selection extends Example {
	
	/**
	 * 对给定数组进行选择排序
	 * @param a 传入的是一个实现了Comparable接口的数组
	 */
	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] a) {
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
}
