package structure;
/**
 * 泛型定容栈
 * @author Administrator
 *
 */
public class FixedCapacityStack<T> {
	private T[] item;
	private int N;
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		item = (T[]) new Object[cap];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(T x) {
		if (N == item.length)
			resize(2 * item.length);
		item[N++] = x;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = item[i];
		}
		item = temp;
	}
	
	public T pop() {
		T temp = item[--N];
		item[N] = null;
		if (N > 0 && N == item.length / 4)
			resize(item.length / 2);
		return temp;
	}
}
