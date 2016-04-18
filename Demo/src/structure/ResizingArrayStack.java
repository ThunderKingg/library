package structure;

import java.util.Iterator;
/**
 * 下压(LIFO)栈(能够动态调整数组大小的实现)
 * 
 * 这份泛型的可迭代的Stack API 的实现是所有集合类抽象数据类型实现的模板。它将所有元素保存在数组中，
 * 并动态调整数组大小以保持数组大小和栈大小之比小于一个常数
 * @author Administrator
 *
 * @param <E>
 */
public class ResizingArrayStack<E> implements Iterable<E> {
	private E[] items = (E[])new Object[1];
	private int size = 0;
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	private void resize(int max){
		E[] temp = (E[])new Object[max];
		for(int i = 0; i < size; i++){
			temp[i] = items[i];
		}
		items = temp;
	}
	
	public void push(E x){
		if(size == items.length){
			resize(size*2);
		}
		items[size++] = x;
	}
	
	public E pop(){
		E x = items[--size];
		items[size] = null; //避免对象游离
		if(size > 0 && size == items.length/4){
			resize(items.length/2);
		}
		return x;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<E>{
		
		private int n = size;
		
		@Override
		public boolean hasNext() {
			return n > 0;
		}

		@Override
		public E next() {
			return items[--n];
		}
		
	}

}
