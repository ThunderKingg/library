package structure;
/**
 * 泛型优先队列(二叉堆实现)
 * @author 王雷
 *
 * @param <Key> 给定实现了Comparable接口的类型
 */
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n = 0;
	
	/**
	 * 创建一个优先队列
	 */
	public MaxPQ() {}
	
	/**
	 * 创建一个最大容量为max的优先队列
	 * @param max 表示最大容量
	 */
	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max + 1];
	}
	
	/**
	 * 用a[]中的元素创建一个优先队列
	 * @param a 给定数组
	 */
	public MaxPQ(Key[] a) {
		this.pq = a;
	}
	
	/**
	 * 向优先队列中插入一个元素
	 * @param v 给定元素
	 */
	public void insert(Key v) {
		pq[++n] = v;
		swim(n);
	}
	
	/**
	 * 返回最大元素
	 * @return 最大元素
	 */
	public Key max() {
		return pq[1];
	}
	
	/**
	 * 删除并返回最大元素
	 * @return 最大元素
	 */
	public Key delMax() {
		Key max = pq[1];
		exch(1,n--);
		pq[n+1] = null;
		sink(1);
		return max;
	}
	
	/**
	 * 返回队列是否为空
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * 返回优先队列中的元素个数
	 * @return 元素个数
	 */
	public int size() {
		return n;
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	/**
	 * 由下至上堆有序化
	 * @param k
	 */
	@SuppressWarnings("unused")
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k / 2;
		}
	}
	/**
	 * 由上至下堆有序化
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2*k;
			if (j < n && less(j, j+1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
}

