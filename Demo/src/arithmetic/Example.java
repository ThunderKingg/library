package arithmetic;

/**
 * 排序抽象类
 * 
 * @author 王雷
 *
 */
public abstract class Example {
	/**
	 * 具体的排序算法
	 * @param a 任意实现了Comparable接口的数组
	 */
	@SuppressWarnings("rawtypes")
	public abstract void sort(Comparable[] a);
	
	/**
	 * 对元素进行比较
	 * @param v 元素v
	 * @param w 元素w
	 * @return v是否小于w的结果，返回boolean类型
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * 对给定数组给定的两个下标交换位置
	 * @param a 给定的数组
	 * @param i 需要交换元素下标
	 * @param j 需要交换元素下标
	 */
	@SuppressWarnings("rawtypes")
	protected void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	@SuppressWarnings("rawtypes")
	public void show(Comparable[] a) {
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
	@SuppressWarnings("rawtypes")
	public boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
}
